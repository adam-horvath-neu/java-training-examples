package hu.training.authenticator;

import hu.training.authenticator.dto.User;

public interface Authenticator {
	boolean authenticate(User user);
}
