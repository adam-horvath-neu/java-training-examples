package hu.training.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMyFirstMavenApp {

	@Test
	public void testHello() {
		assertEquals("hello", MyFirstMavenApp.hello());
	}
}
