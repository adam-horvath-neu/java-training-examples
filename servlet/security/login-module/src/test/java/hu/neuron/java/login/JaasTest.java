package hu.neuron.java.login;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import junit.framework.TestCase;

public class JaasTest extends TestCase {

	public void testLogin() {

		System.setProperty("java.security.auth.login.config",
				"src/test/resources/jaas.config");

		try {
			CustomCallbackHandler paramCallbackHandler = new CustomCallbackHandler(
					"admin", "admin".toCharArray());

			LoginContext lc = new LoginContext("Test", paramCallbackHandler);
			lc.login();
		} catch (LoginException e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}

	public void testLoginFailed() {

		System.setProperty("java.security.auth.login.config",
				"src/test/resources/jaas.config");

		try {
			CustomCallbackHandler paramCallbackHandler = new CustomCallbackHandler(
					"admin", "admin2".toCharArray());

			LoginContext lc = new LoginContext("Test", paramCallbackHandler);
			lc.login();
			assertTrue(false);
		} catch (LoginException e) {
			e.printStackTrace();
			assertTrue(true);
		}

	}

}
