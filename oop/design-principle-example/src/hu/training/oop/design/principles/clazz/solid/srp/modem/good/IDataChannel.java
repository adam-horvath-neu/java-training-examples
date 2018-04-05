/**
 * 
 */
package hu.training.oop.design.principles.clazz.solid.srp.modem.good;

/**
 * Interface designed for data management responsibilities of modem
 * 
 * @author Janos Pelsoczi
 * 
 */
public interface IDataChannel {

	public void send(char c);

	public char receive();

}
