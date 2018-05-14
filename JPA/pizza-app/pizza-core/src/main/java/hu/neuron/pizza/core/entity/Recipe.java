package hu.neuron.pizza.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Recipe extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String name;

	@Lob
	private byte[] image;

	@OneToMany
	private List<Topping> toppings;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}

}
