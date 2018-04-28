package hu.neuron.core.dao;

import hu.neuron.core.dto.UserDto;

public interface UserDao extends GenericDao<UserDto> {

	UserDto findByName(String name);
}
