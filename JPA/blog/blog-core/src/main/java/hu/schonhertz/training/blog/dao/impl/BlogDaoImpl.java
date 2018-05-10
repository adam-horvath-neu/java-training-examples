package hu.schonhertz.training.blog.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hu.schonhertz.training.blog.dao.client.BlogDao;
import hu.schonhertz.training.blog.dao.mapper.BlogMapper;
import hu.schonhertz.training.blog.dto.client.BlogDto;
import hu.schonhertz.training.blog.entity.Blog;

@Stateless
@Local(BlogDao.class)
public class BlogDaoImpl implements BlogDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public Long save(BlogDto dto) throws Exception {
		Blog entity = BlogMapper.toEntity(dto, null);
		entityManager.persist(entity);
		return entity.getId();
	}

	@Override
	public void update(BlogDto dto) throws Exception {
		Blog entity = BlogMapper.toEntity(dto, null);
		entityManager.merge(entity);

	}

	@Override
	public void delete(Long id) throws Exception {
		Blog blog = this.entityManager.find(Blog.class, id);
		entityManager.remove(blog);
	}

	@Override
	public BlogDto find(Long id) throws Exception {
		return BlogMapper.toDto(this.entityManager.find(Blog.class, id));
	}

	@Override
	public List<BlogDto> findAll() throws Exception {
		List<Blog> resultList = entityManager.createQuery("Select t from Blog t", Blog.class).getResultList();
		List<BlogDto> rv = new ArrayList<BlogDto>();
		for (Blog e : resultList) {
			rv.add(BlogMapper.toDto(e));
		}
		return rv;
	}

}
