package hu.neuron.pizza.service.mapper;

import hu.neuron.pizza.core.entity.User;
import hu.neuron.pizza.service.vo.UserVo;

public class UserMapper extends GenericMapper<User, UserVo> {

	private static final long serialVersionUID = 1L;

	private UserMapper(Class<UserVo> voClazz, Class<User> entityClazz) {
		super(voClazz, entityClazz);
	}

	public UserMapper() {
		super(UserVo.class, User.class);
	}

}
