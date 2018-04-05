/**
 * 
 */
package hu.training.oop.design.principles.clazz.solid.srp.modem.good;

/**
 * Interface designed for connection management responsibilities of modem
 * 
 * @author Janos Pelsoczi
 *
 */
public interface IConnection {
	
	public void dial(String phoneNumber);

	public void disconnect();

}
