package hu.schonhertz.training.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import hu.schonhertz.training.blog.dao.client.UserDao;
import hu.schonhertz.training.blog.dao.mapper.UserMapper;
import hu.schonhertz.training.blog.dto.client.UserDto;
import hu.schonhertz.training.blog.entity.User;

@Stateless
@Local(UserDao.class)
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public UserDto findUserByName(String name) throws Exception {
		User rv;
		try {
			Query query = entityManager.createNamedQuery("findUserByName", User.class);
			query.setParameter("pName", name);

			rv = (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return UserMapper.toDto(rv);
	}

	@Override
	public Long save(UserDto dto) throws Exception {
		User entity = UserMapper.toEntity(dto, null);
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public void update(UserDto dto) throws Exception {
		User entity = UserMapper.toEntity(dto, null);
		entityManager.merge(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		User blog = this.entityManager.find(User.class, id);
		entityManager.remove(blog);
	}

	@Override
	public UserDto find(Long id) throws Exception {
		return UserMapper.toDto(this.entityManager.find(User.class, id));
	}

	@Override
	public List<UserDto> findAll() throws Exception {
		List<User> resultList = entityManager.createQuery("Select t from User t", User.class).getResultList();
		List<UserDto> rv = new ArrayList<UserDto>();
		for (User e : resultList) {
			rv.add(UserMapper.toDto(e));
		}
		return rv;
	}

}
