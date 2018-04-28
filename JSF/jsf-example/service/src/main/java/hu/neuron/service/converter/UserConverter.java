package hu.neuron.service.converter;

import java.util.ArrayList;
import java.util.List;

import hu.neuron.core.dao.RoleDao;
import hu.neuron.core.dao.impl.RoleDaoImpl;
import hu.neuron.core.dto.RoleDto;
import hu.neuron.core.dto.UserDto;
import hu.neuron.service.vo.Gender;
import hu.neuron.service.vo.UserVo;

public class UserConverter {

	public static UserVo toUserVo(UserDto dto) {
		if (dto == null) {
			return null;
		}
		UserVo userVo = new UserVo();
		userVo.setUsername(dto.getUsername());
		userVo.setPassword(dto.getPassword());
		userVo.setId(dto.getId());
		if (dto.getGender() != null) {
			userVo.setGender(Gender.valueOf(dto.getGender()));
		}
		userVo.setImage(dto.getImage());
		// RoleDao roleDao = new RoleDaoImpl();

		// List<RoleDto> roles = roleDao.findRolesByUser(dto.getId());
		// userVo.setRoles(roles);
		return userVo;
	}

	public static List<UserVo> toUserVo(List<UserDto> dtos) {
		List<UserVo> rv = new ArrayList<>();
		for (UserDto dto : dtos) {
			rv.add(toUserVo(dto));
		}
		return rv;
	}

	public static UserDto toUserDto(UserVo vo) {
		UserDto userDto = new UserDto();
		userDto.setId(vo.getId());
		userDto.setPassword(vo.getPassword());
		userDto.setUsername(vo.getUsername());
		if (vo.getGender() != null) {
			userDto.setGender(vo.getGender().name());
		}
		userDto.setImage(vo.getImage());
		return userDto;
	}

	public static List<UserDto> toUserDto(List<UserVo> vos) {
		List<UserDto> rv = new ArrayList<>();
		for (UserVo vo : vos) {
			rv.add(toUserDto(vo));
		}
		return rv;
	}

}
