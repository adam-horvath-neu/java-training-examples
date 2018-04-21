package hu.neuron.java.login;

import java.security.Principal;

public class RolePrincipal implements Principal {

	private String name;

	public RolePrincipal(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "RolePrincipal [name=" + name + "]";
	}

}