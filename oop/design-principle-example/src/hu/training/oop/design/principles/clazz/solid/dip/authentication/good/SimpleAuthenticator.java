package hu.training.oop.design.principles.clazz.solid.dip.authentication.good;

/**
 * The example low level class, which would provide implementation of
 * authentication by database
 * 
 * @author Janos Pelsoczi
 *
 */
public class SimpleAuthenticator implements Authenticator {

	@Override
	public boolean authenticate(User user) {
		System.out.println("Authenticated by Simple");
		return true;
	}
}
