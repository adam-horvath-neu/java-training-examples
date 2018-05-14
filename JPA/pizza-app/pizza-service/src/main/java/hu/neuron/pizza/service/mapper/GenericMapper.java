package hu.neuron.pizza.service.mapper;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import hu.neuron.pizza.core.entity.BaseEntity;
import hu.neuron.pizza.service.vo.BaseVo;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class GenericMapper<E extends BaseEntity, V extends BaseVo> implements Serializable {

	private static final long serialVersionUID = -8813309091228116063L;

	private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	private final MapperFacade mapper = mapperFactory.getMapperFacade();

	private final Class<V> voClazz;
	private final Class<E> entityClazz;

	public GenericMapper(Class<V> voClazz, Class<E> entityClazz) {
		super();
		this.voClazz = voClazz;
		this.entityClazz = entityClazz;
	}

	public V toVo(E entity) {
		if (entity == null) {
			return null;
		}
		return mapper.map(entity, voClazz);
	}

	public E toEntity(V vo) {
		if (vo == null) {
			return null;
		}
		return mapper.map(vo, entityClazz);
	}

	public List<V> toVo(List<E> entities) {
		if (entities == null) {
			return Collections.emptyList();
		}
		return mapper.mapAsList(entities, voClazz);
	}

	public List<E> toEntity(List<V> vos) {
		if (vos == null) {
			return Collections.emptyList();
		}
		return mapper.mapAsList(vos, entityClazz);
	}

}
