package hu.neuron.pizza.core.dao;

import java.util.List;

import hu.neuron.pizza.core.entity.BaseEntity;

public interface BaseDao<E extends BaseEntity> {

	Long save(E entity);

	E find(Long id);

	void update(E entity);

	void remove(Long id);

	List<E> findAll();

}
