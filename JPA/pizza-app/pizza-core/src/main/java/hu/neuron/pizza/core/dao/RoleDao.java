package hu.neuron.pizza.core.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.neuron.pizza.core.entity.Role;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class RoleDao implements BaseDao<Role> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long save(Role entity) {
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public Role find(Long id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public void update(Role entity) {
		entityManager.merge(entity);

	}

	@Override
	public void remove(Long id) {
		entityManager.remove(find(id));
	}

	@Override
	public List<Role> findAll() {
		TypedQuery<Role> typedQuery = entityManager.createQuery("select a from Role a", Role.class);
		return typedQuery.getResultList();
	}

}
