package hu.neuron.pizza.core.entity;

import javax.persistence.Entity;

@Entity
public class Role extends BaseEntity {

	private static final long serialVersionUID = 3966202467529552265L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
