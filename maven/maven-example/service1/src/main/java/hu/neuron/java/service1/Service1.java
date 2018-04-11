package hu.neuron.java.service1;

import org.apache.log4j.Logger;

import hu.neuron.java.Hello;

/**
 * Hello world!
 * 
 */
public class Service1 {

	private static final Logger logger = Logger.getLogger(Service1.class);

	public String hello() {
		Hello hello = new Hello();
		logger.debug("hello");
		return hello.hello("Hello Service1");

	}
}
