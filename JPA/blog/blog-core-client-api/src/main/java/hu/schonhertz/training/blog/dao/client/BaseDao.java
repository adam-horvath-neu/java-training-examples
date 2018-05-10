package hu.schonhertz.training.blog.dao.client;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

	public Long save(T dto) throws Exception;

	public void update(T dto) throws Exception;

	public void delete(Long id) throws Exception;

	public T find(Long id) throws Exception;

	public List<T> findAll() throws Exception;

	
}
