package hu.neuron.service.converter;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.neuron.core.dao.RoleDao;
import hu.neuron.core.dto.RoleDto;
import hu.neuron.core.dto.UserDto;
import hu.neuron.service.vo.Gender;
import hu.neuron.service.vo.UserVo;

@Named
@ApplicationScoped
public class UserConverter {

	@Inject
	private RoleDao roleDao;

	@Inject
	private RoleConverter roleConverter;

	public UserVo toUserVo(UserDto dto) {
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

		userVo.setFirstname(dto.getFirstname());
		userVo.setLastname(dto.getLastname());
		userVo.setEmail(dto.getEmail());
		userVo.setPhone(dto.getPhone());

		List<RoleDto> roles = roleDao.findRolesByUser(dto.getId());
		userVo.setRoles(roleConverter.toRoleVo(roles));
		
		return userVo;
	}

	public List<UserVo> toUserVo(List<UserDto> dtos) {
		List<UserVo> rv = new ArrayList<>();
		for (UserDto dto : dtos) {
			rv.add(toUserVo(dto));
		}
		return rv;
	}

	public UserDto toUserDto(UserVo vo) {
		UserDto userDto = new UserDto();
		userDto.setId(vo.getId());
		userDto.setPassword(vo.getPassword());
		userDto.setUsername(vo.getUsername());
		if (vo.getGender() != null) {
			userDto.setGender(vo.getGender().name());
		}
		userDto.setImage(vo.getImage());

		userDto.setFirstname(vo.getFirstname());
		userDto.setLastname(vo.getLastname());
		userDto.setEmail(vo.getEmail());
		userDto.setPhone(vo.getPhone());
		return userDto;
	}

	public List<UserDto> toUserDto(List<UserVo> vos) {
		List<UserDto> rv = new ArrayList<>();
		for (UserVo vo : vos) {
			rv.add(toUserDto(vo));
		}
		return rv;
	}

}
