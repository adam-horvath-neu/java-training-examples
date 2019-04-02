package hu.neuron.pizza.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import hu.neuron.pizza.core.dao.PizzaDao;
import hu.neuron.pizza.service.mapper.PizzaMapper;
import hu.neuron.pizza.service.pizza.PizzaServiceLocal;
import hu.neuron.pizza.service.pizza.PizzaServiceRemote;
import hu.neuron.pizza.service.vo.pizza.PizzaVo;

@Stateless
@Local(PizzaServiceLocal.class)
@Remote(PizzaServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PizzaServiceBean implements PizzaServiceLocal, PizzaServiceRemote {
	
	@EJB
	private PizzaDao pizzaDao;
	
	private PizzaMapper pizzaMapper;
	

	@PostConstruct
	public void init() {
		this.pizzaMapper = new PizzaMapper();
	}
	
	@Override
	public List<PizzaVo> getAllPizza() {
		return this.pizzaMapper.toVo(this.pizzaDao.findAll());
	}

}
