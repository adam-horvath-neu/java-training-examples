package hu.neuron.pizza.service.mapper;

import hu.neuron.pizza.core.entity.Pizza;
import hu.neuron.pizza.service.vo.pizza.PizzaVo;

public class PizzaMapper extends GenericMapper<Pizza, PizzaVo> {
	
	private static final long serialVersionUID = -6506739893660726045L;
	
	public PizzaMapper() {
		super(PizzaVo.class, Pizza.class);
	}

	private PizzaMapper(Class<PizzaVo> voClazz, Class<Pizza> entityClazz) {
		super(voClazz, entityClazz);
	}

}
