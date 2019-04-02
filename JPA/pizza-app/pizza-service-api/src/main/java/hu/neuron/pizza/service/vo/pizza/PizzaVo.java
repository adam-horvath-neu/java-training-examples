package hu.neuron.pizza.service.vo.pizza;

import java.util.List;

import hu.neuron.pizza.service.vo.BaseVo;

public class PizzaVo extends BaseVo {

	private String name;
	private Long price;
	private String imageUrl;
	private List<ToppingVo> toppings;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<ToppingVo> getToppings() {
		return toppings;
	}

	public void setToppings(List<ToppingVo> toppings) {
		this.toppings = toppings;
	}

}
