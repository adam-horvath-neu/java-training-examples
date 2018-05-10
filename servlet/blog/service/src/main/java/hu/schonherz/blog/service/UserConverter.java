package hu.schonherz.blog.service;

import hu.schonherz.blog.core.UserDto;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.User;

public class UserConverter {

	public static User toUser(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		
		Name name = new Name();
		name.setFirst(dto.getFirstname());
		name.setLast(dto.getLastname());
		user.setName(name);
		
		Login login = new Login();
		login.setPassword(dto.getPassword());
		user.setLogin(login);
		
		return user;

	}
}
