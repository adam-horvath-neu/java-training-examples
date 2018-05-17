package hu.neuron.java.rs;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/resources")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
		return getRestClasses();
	}

	private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();

		resources.add(UserRestWebService.class);
		return resources;
	}
}