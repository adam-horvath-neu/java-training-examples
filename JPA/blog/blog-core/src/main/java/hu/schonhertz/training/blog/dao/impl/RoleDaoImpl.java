package hu.schonhertz.training.blog.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.schonhertz.training.blog.dao.client.RoleDao;
import hu.schonhertz.training.blog.dao.client.UserDao;
import hu.schonhertz.training.blog.dao.mapper.RoleMapper;
import hu.schonhertz.training.blog.dao.mapper.UserMapper;
import hu.schonhertz.training.blog.dto.client.RoleDto;
import hu.schonhertz.training.blog.dto.client.RoleDto;
import hu.schonhertz.training.blog.dto.client.UserDto;
import hu.schonhertz.training.blog.entity.Blog;
import hu.schonhertz.training.blog.entity.Role;
import hu.schonhertz.training.blog.entity.Role;
import hu.schonhertz.training.blog.entity.User;

@Stateless
@Local(RoleDao.class)
public class RoleDaoImpl implements RoleDao {
	@PersistenceContext
	protected EntityManager entityManager;

	@EJB
	UserDao userDao;

	@Override
	public List<RoleDto> findRolesByUserId(Long id) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery("findRolesByUserId", Role.class);
		createNamedQuery.setParameter("pUserId", id);
		List<Role> resultList = createNamedQuery.getResultList();

		List<RoleDto> rv = new ArrayList<RoleDto>();
		for (Role e : resultList) {
			rv.add(RoleMapper.toDto(e));
		}
		return rv;

	}

	@Override
	public void addRoleToUser(Long roleId, Long userId) throws Exception {
		User user = this.entityManager.find(User.class, userId);

		Collection<Role> roles = user.getRoles();
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		roles.add(this.entityManager.find(Role.class, roleId));
		user.setRoles(roles);
		entityManager.persist(user);
	}

	@Override
	public void removeRoleFromUser(Long roleId, Long userId) throws Exception {
		User user = this.entityManager.find(User.class, userId);
		user.getRoles().remove(this.entityManager.find(Role.class, roleId));
		entityManager.persist(user);

	}

	@Override
	public RoleDto findRoleByName(String name) throws Exception {
		TypedQuery<Role> createNamedQuery = entityManager.createNamedQuery("findRoleByName", Role.class);
		createNamedQuery.setParameter("pName", name);

		Role rv = null;
		try {
			rv = createNamedQuery.getSingleResult();
		} catch (NoResultException e) {

		}
		return RoleMapper.toDto(rv);
	}

	@Override
	public Long save(RoleDto dto) throws Exception {
		Role entity = RoleMapper.toEntity(dto, null);
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public void update(RoleDto dto) throws Exception {
		Role entity = RoleMapper.toEntity(dto, null);
		entityManager.merge(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		Role blog = this.entityManager.find(Role.class, id);
		entityManager.remove(blog);
	}

	@Override
	public RoleDto find(Long id) throws Exception {
		return RoleMapper.toDto(this.entityManager.find(Role.class, id));
	}

	@Override
	public List<RoleDto> findAll() throws Exception {
		List<Role> resultList = entityManager.createQuery("Select t from Role t", Role.class).getResultList();
		List<RoleDto> rv = new ArrayList<RoleDto>();
		for (Role e : resultList) {
			rv.add(RoleMapper.toDto(e));
		}
		return rv;
	}
}
