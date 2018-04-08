package hu.training.login;

import hu.training.authenticator.Authenticator;
import hu.training.authenticator.dto.User;
import hu.training.servicelocator.ServiceLocator;

public class LoginBean {
	
	public boolean login(String username, String password) {
		Authenticator authenticator = ServiceLocator.getDbAuthenticator();
		return authenticator.authenticate(new User(username, password));
	}

}
