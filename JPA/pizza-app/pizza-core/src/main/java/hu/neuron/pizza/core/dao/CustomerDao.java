package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Customer;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class CustomerDao implements BaseDao<Customer> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Customer entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public Customer find(Long id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public void update(Customer entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<Customer> findAll() {
		TypedQuery<Customer> typedQuery = entityManager.createQuery("select a from Customer a", Customer.class);
		return typedQuery.getResultList();
	}

}
