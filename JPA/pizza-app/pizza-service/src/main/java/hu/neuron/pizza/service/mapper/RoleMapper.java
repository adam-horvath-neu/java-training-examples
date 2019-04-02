package hu.neuron.pizza.service.mapper;

import hu.neuron.pizza.core.entity.Role;
import hu.neuron.pizza.service.vo.user.RoleVo;

public class RoleMapper extends GenericMapper<Role, RoleVo> {

	private static final long serialVersionUID = 1L;

	private RoleMapper(Class<RoleVo> voClazz, Class<Role> entityClazz) {
		super(voClazz, entityClazz);
	}

	public RoleMapper() {
		super(RoleVo.class, Role.class);
	}

}
