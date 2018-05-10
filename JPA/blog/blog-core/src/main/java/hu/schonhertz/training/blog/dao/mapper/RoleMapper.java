package hu.schonhertz.training.blog.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.client.RoleDto;
import hu.schonhertz.training.blog.entity.Role;

public class RoleMapper {

	public static Role toEntity(RoleDto dto, Role entity) {
		Role ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new Role();

		}
		ret.setId(dto.getId());
		ret.setName(dto.getName());
		return ret;
	}

	public static RoleDto toDto(Role entity) {
		RoleDto ret = new RoleDto();
		if (entity == null) {
			return null;
		}
		ret.setName(entity.getName());
		ret.setId(entity.getId());

		return ret;
	}

}
