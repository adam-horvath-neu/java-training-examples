package hu.training.app;

import org.apache.commons.lang3.StringUtils;

public class MyFirstMavenApp {

	public static void main(String[] args) {
		// A StringUtils a pom.xml-ben meghatározott org.apache.commons.commons-lang3
		// függőségben található.
		if (!StringUtils.isEmpty(hello())) {
			System.out.println(hello());
		} else {
			System.out.println("Empty hello!");
		}
	}

	public static String hello() {
		return "hello";
	}

}
