package hu.neuron.java.ejb;

import hu.neuron.java.service1.Service1;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloEjb
 */
@Stateless
public class HelloEjb implements HelloEjbRemote, HelloEjbLocal {

	/**
	 * Default constructor.
	 */
	public HelloEjb() {
		Service1 service1 = new Service1();
		service1.hello();
	}

}
