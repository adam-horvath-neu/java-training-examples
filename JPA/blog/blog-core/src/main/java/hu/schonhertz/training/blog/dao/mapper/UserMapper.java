package hu.schonhertz.training.blog.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.client.UserDto;
import hu.schonhertz.training.blog.entity.User;

public class UserMapper {

	
	public static User toEntity(UserDto dto, User entity) {
		User ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new User();
			ret.setId(dto.getId());

		}
		ret.setId(dto.getId());
		ret.setUserName(dto.getUserName());
		ret.setPassword(dto.getPassword());

		return ret;
	}

	public static UserDto toDto(User entity) {
		UserDto ret = new UserDto();
		if (entity == null) {
			return null;
		}
		ret.setId(entity.getId());
		ret.setUserName(entity.getUserName());
		ret.setPassword(entity.getPassword());

		return ret;
	}

}
