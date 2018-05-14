package hu.neuron.pizza.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Pizza extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String nameOnBox;

	@ManyToMany
	private List<Topping> selectedToppings;

	@OneToOne
	private Recipe recipe;

	
	public String getNameOnBox() {
		return nameOnBox;
	}

	public void setNameOnBox(String nameOnBox) {
		this.nameOnBox = nameOnBox;
	}

	public List<Topping> getSelectedToppings() {
		return selectedToppings;
	}

	public void setSelectedToppings(List<Topping> selectedToppings) {
		this.selectedToppings = selectedToppings;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
