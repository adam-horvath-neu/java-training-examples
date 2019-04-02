package hu.neuron.pizza.core.entity;

import javax.persistence.Entity;

@Entity
public class Topping extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
