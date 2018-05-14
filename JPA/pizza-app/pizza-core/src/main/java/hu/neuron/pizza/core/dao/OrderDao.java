package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Order;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class OrderDao implements BaseDao<Order> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Order entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public Order find(Long id) {
		return entityManager.find(Order.class, id);
	}

	@Override
	public void update(Order entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<Order> findAll() {
		TypedQuery<Order> typedQuery = entityManager.createQuery("select a from Order a", Order.class);
		return typedQuery.getResultList();
	}

}
