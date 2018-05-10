package hu.schonhertz.training.blog.dao.client;

import hu.schonhertz.training.blog.dto.client.UserDto;

public interface UserDao extends BaseDao<UserDto> {

	UserDto findUserByName(String name) throws Exception;

}
