package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Recipe;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class RecipeDao implements BaseDao<Recipe> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Recipe entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public Recipe find(Long id) {
		return entityManager.find(Recipe.class, id);
	}

	@Override
	public void update(Recipe entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<Recipe> findAll() {
		TypedQuery<Recipe> typedQuery = entityManager.createQuery("select a from Recipe a", Recipe.class);
		return typedQuery.getResultList();
	}

}
