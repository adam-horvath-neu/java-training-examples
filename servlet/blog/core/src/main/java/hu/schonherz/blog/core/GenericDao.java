package hu.schonherz.blog.core;

import java.util.List;

public interface GenericDao<T> {

	Long save(T t);

	T update(T t);

	void delete(Long id);

	List<T> findAll();

	T find(Long id);
}
