package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Address;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class AddressDao implements BaseDao<Address> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Address entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public Address find(Long id) {
		return entityManager.find(Address.class, id);
	}

	@Override
	public void update(Address entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<Address> findAll() {
		TypedQuery<Address> typedQuery = entityManager.createQuery("select a from Address a", Address.class);
		return typedQuery.getResultList();
	}

}
