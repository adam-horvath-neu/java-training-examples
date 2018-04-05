package hu.training.oop.design.principles.clazz.solid.srp.modem.good;


/**
 * @author Janos Pelsoczi
 *
 */
public class ModemFastClient {	
	
	public static void main(String[] args) {
		
		Modem modem = new Modem(new ConnectionManager(), new DataChannelFastMode());
		
		modem.dial("0000000000");
		modem.send('t');
		modem.receive();
		modem.disconnect();
	}

}
