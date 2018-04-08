package hu.training.authenticator;

import hu.training.authenticator.dto.User;
import hu.training.authenticator.user.UsersMock;

public class DBAuthenticator implements Authenticator {

	public boolean authenticate(User user) {
		System.out.println("Authenticate by DB");
		return UsersMock.getUsers().contains(user);
	}

}
