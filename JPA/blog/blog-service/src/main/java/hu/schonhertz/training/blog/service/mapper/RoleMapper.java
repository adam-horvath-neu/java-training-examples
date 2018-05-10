package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.client.RoleDto;
import hu.schonhertz.training.blog.vo.RoleVo;

public class RoleMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static RoleVo toVo(RoleDto blogDto) {
		if (blogDto == null) {
			return null;
		}
		return mapper.map(blogDto, RoleVo.class);
	}

	public static RoleDto toDto(RoleVo blogVo) {
		if (blogVo == null) {
			return null;
		}
		return mapper.map(blogVo, RoleDto.class);
	}

	public static List<RoleVo> toVo(List<RoleDto> blogDtos) {
		List<RoleVo> blogVos = new ArrayList<>();
		for (RoleDto blogDto : blogDtos) {
			blogVos.add(toVo(blogDto));
		}
		return blogVos;
	}

	public static List<RoleDto> toDto(List<RoleVo> blogVos) {
		List<RoleDto> blogDtos = new ArrayList<>();
		for (RoleVo blogVo : blogVos) {
			blogDtos.add(toDto(blogVo));
		}
		return blogDtos;
	}

}
