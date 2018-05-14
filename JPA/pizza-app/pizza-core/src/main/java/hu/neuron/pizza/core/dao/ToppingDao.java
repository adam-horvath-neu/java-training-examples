package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Topping;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ToppingDao implements BaseDao<Topping> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Topping entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public Topping find(Long id) {
		return entityManager.find(Topping.class, id);
	}

	@Override
	public void update(Topping entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<Topping> findAll() {
		TypedQuery<Topping> typedQuery = entityManager.createQuery("select a from Topping a", Topping.class);
		return typedQuery.getResultList();
	}

}
