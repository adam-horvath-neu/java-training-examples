package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Pizza;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PizzaDao implements BaseDao<Pizza> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Pizza entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public Pizza find(Long id) {
		return entityManager.find(Pizza.class, id);
	}

	@Override
	public void update(Pizza entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<Pizza> findAll() {
		TypedQuery<Pizza> typedQuery = entityManager.createQuery("select a from Pizza a", Pizza.class);
		return typedQuery.getResultList();
	}

}
