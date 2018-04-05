package hu.training.oop.design.principles.clazz.solid.srp.modem.bad;

/**
 * This is client or consumer of ModemFast class.
 * 
 * @author Janos Pelsoczi
 */
public class ModemFastClient {	
	
	public static void main(String[] args) {
				
		IModem fastModem = new ModemFast();
		
		fastModem.dial("0000000000");
		fastModem.send('t');
		fastModem.receive();
		fastModem.disconnect();
	}

}
