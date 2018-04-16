package hu.neuron.java.login;

import java.security.Principal;
import java.util.Collection;

public class UserPrincipal implements Principal {

	private String name;
	
	private Collection<RolePrincipal> roles;
	

	public UserPrincipal(String name) {
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
		return "UserPrincipal [name=" + name + "]";
	}

	public Collection<RolePrincipal> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolePrincipal> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPrincipal other = (UserPrincipal) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}