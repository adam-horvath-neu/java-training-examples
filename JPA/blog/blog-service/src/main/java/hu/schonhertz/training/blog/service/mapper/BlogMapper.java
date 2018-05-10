package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.client.BlogDto;
import hu.schonhertz.training.blog.vo.BlogVo;

public class BlogMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static BlogVo toVo(BlogDto blogDto) {
		if (blogDto == null) {
			return null;
		}
		return mapper.map(blogDto, BlogVo.class);
	}

	public static BlogDto toDto(BlogVo blogVo) {
		if (blogVo == null) {
			return null;
		}
		return mapper.map(blogVo, BlogDto.class);
	}

	public static List<BlogVo> toVo(List<BlogDto> blogDtos) {
		List<BlogVo> blogVos = new ArrayList<>();
		for (BlogDto blogDto : blogDtos) {
			blogVos.add(toVo(blogDto));
		}
		return blogVos;
	}

	public static List<BlogDto> toDto(List<BlogVo> blogVos) {
		List<BlogDto> blogDtos = new ArrayList<>();
		for (BlogVo blogVo : blogVos) {
			blogDtos.add(toDto(blogVo));
		}
		return blogDtos;
	}

}
