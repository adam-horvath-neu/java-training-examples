package hu.neuron.java.service2;

import hu.neuron.java.Hello;

/**
 * Hello world!
 * 
 */
public class Service2 {
	public String hello() {
		Hello hello = new Hello();
		return hello.hello("Hello Service2");
	}
}
