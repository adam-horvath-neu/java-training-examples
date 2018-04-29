package hu.neuron.service.converter;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import hu.neuron.core.dto.RoleDto;
import hu.neuron.service.vo.RoleVo;

@Named
@ApplicationScoped
public class RoleConverter {

	public RoleVo toRoleVo(RoleDto dto) {
		if (dto == null) {
			return null;
		}
		RoleVo roleVo = new RoleVo();
		roleVo.setName(dto.getName());
		roleVo.setId(dto.getId());

		return roleVo;
	}

	public List<RoleVo> toRoleVo(List<RoleDto> dtos) {
		List<RoleVo> rv = new ArrayList<>();
		for (RoleDto dto : dtos) {
			rv.add(toRoleVo(dto));
		}
		return rv;
	}

	public RoleDto toRoleDto(RoleVo vo) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(vo.getId());
		roleDto.setName(vo.getName());
		return roleDto;
	}

	public List<RoleDto> toRoleDto(List<RoleVo> vos) {
		List<RoleDto> rv = new ArrayList<>();
		for (RoleVo vo : vos) {
			rv.add(toRoleDto(vo));
		}
		return rv;
	}

}
