package hu.schonhertz.training.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hu.schonhertz.training.blog.dao.client.CommentDao;
import hu.schonhertz.training.blog.dao.mapper.CommentMapper;
import hu.schonhertz.training.blog.dto.client.CommentDto;
import hu.schonhertz.training.blog.entity.Comment;

@Stateless
@Local(CommentDao.class)
public class CommentDaoImpl implements CommentDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Long save(CommentDto dto) throws Exception {
		Comment entity = CommentMapper.toEntity(dto, null);
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public void update(CommentDto dto) throws Exception {
		Comment entity = CommentMapper.toEntity(dto, null);
		entityManager.merge(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		Comment blog = this.entityManager.find(Comment.class, id);
		entityManager.remove(blog);
	}

	@Override
	public CommentDto find(Long id) throws Exception {
		return CommentMapper.toDto(this.entityManager.find(Comment.class, id));
	}

	@Override
	public List<CommentDto> findAll() throws Exception {
		List<Comment> resultList = entityManager.createQuery("Select t from Comment t", Comment.class).getResultList();
		List<CommentDto> rv = new ArrayList<CommentDto>();
		for (Comment e : resultList) {
			rv.add(CommentMapper.toDto(e));
		}
		return rv;
	}

}
