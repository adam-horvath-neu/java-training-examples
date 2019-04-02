package hu.neuron.pizza.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import hu.neuron.pizza.service.pizza.PizzaServiceLocal;
import hu.neuron.pizza.service.vo.pizza.PizzaVo;

@Named("pizzaBean")
@ViewScoped
public class PizzaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PizzaServiceLocal pizzaService;
	
	private List<PizzaVo> availablePizzas;
	
	@PostConstruct
	public void init() {
		this.availablePizzas = this.pizzaService.getAllPizza();
	}
	
	public List<PizzaVo> getAvailablePizzas() {
		return availablePizzas;
	}

	public void setPizzaService(PizzaServiceLocal pizzaService) {
		this.pizzaService = pizzaService;
	}

}
