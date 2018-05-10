package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.client.UserDto;
import hu.schonhertz.training.blog.vo.UserVo;

public class UserMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static UserVo toVo(UserDto blogDto) {
		if (blogDto == null) {
			return null;
		}
		return mapper.map(blogDto, UserVo.class);
	}

	public static UserDto toDto(UserVo blogVo) {
		if (blogVo == null) {
			return null;
		}
		return mapper.map(blogVo, UserDto.class);
	}

	public static List<UserVo> toVo(List<UserDto> blogDtos) {
		List<UserVo> blogVos = new ArrayList<>();
		for (UserDto blogDto : blogDtos) {
			blogVos.add(toVo(blogDto));
		}
		return blogVos;
	}

	public static List<UserDto> toDto(List<UserVo> blogVos) {
		List<UserDto> blogDtos = new ArrayList<>();
		for (UserVo blogVo : blogVos) {
			blogDtos.add(toDto(blogVo));
		}
		return blogDtos;
	}

}
