package hu.training.oop.design.principles.clazz.solid.dip.authentication.good;

/**
 * The example low level interface to provide abstraction
 * 
 * @author Janos Pelsoczi
 *
 */
public interface Authenticator {

	boolean authenticate(User user);
	
}
