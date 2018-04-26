package hu.neuron.core.dao;

import java.util.List;

public interface GenericDao<T> {

	Long save(T t);

	void delete(Long id);

	T upadte(T t);

	T find(Long id);

	List<T> findAll();
}
