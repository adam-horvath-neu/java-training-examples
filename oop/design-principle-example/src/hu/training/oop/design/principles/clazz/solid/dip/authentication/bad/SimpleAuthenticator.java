package hu.training.oop.design.principles.clazz.solid.dip.authentication.bad;

/**
 * 
 * Low level class of authentication
 * 
 * @author Janos Pelsoczi
 *
 */
public class SimpleAuthenticator {

	public boolean authenticate(User user) {

		// logic - database

		return true;
	}

}
