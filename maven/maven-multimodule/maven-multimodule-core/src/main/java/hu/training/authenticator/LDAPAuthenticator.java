package hu.training.authenticator;

import hu.training.authenticator.dto.User;
import hu.training.authenticator.user.UsersMock;

public class LDAPAuthenticator implements Authenticator {

	public boolean authenticate(User user) {
		System.out.println("Authenticate by LDAP");
		return UsersMock.getUsers().contains(user);
	}

}
