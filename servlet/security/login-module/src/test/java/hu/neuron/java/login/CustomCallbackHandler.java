package hu.neuron.java.login;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class CustomCallbackHandler implements CallbackHandler {
	private String username;
	private char[] password;

	

	public CustomCallbackHandler(String username, char[] password) {
		super();
		this.username = username;
		this.password = password;
	}



	public void handle(Callback[] suppliedCallback) throws IOException,
			UnsupportedCallbackException {

		for (int i = 0; i < suppliedCallback.length; i++) {
			if (suppliedCallback[i] instanceof NameCallback) {
				((NameCallback) suppliedCallback[i]).setName(username);
			} else if (suppliedCallback[i] instanceof PasswordCallback) {
				((PasswordCallback) suppliedCallback[i]).setPassword(password);
			} else {
				throw new UnsupportedCallbackException(suppliedCallback[i]);
			}
		}

	}

}