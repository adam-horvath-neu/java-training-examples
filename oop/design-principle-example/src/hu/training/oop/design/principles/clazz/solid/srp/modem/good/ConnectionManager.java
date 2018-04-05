/**
 * 
 */
package hu.training.oop.design.principles.clazz.solid.srp.modem.good;

/**
 * Implementation class of IConnection interface for modem's connection
 * management. This is for design demo, so actual logic is not implemented
 * 
 * @author Janos Pelsoczi
 * 
 */
public class ConnectionManager implements IConnection {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.training.oop.design.principles.clazz.solid.srp.modem.good.
	 * IConnection#dial(java.lang.String)
	 */
	@Override
	public void dial(String phoneNumber) {
		// TODO Auto-generated method stub
		System.out.println("connected successfully");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hu.training.oop.design.principles.clazz.solid.srp.modem.good.
	 * IConnection#disconnect()
	 */
	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		System.out.println("disconnection successfully");
	}

}
