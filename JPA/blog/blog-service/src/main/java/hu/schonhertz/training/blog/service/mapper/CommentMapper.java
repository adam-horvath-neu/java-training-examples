package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.client.CommentDto;
import hu.schonhertz.training.blog.vo.CommentVo;

public class CommentMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static CommentVo toVo(CommentDto commentDto) {
		if (commentDto == null) {
			return null;
		}
		return mapper.map(commentDto, CommentVo.class);
	}

	public static CommentDto toDto(CommentVo commentVo) {
		if (commentVo == null) {
			return null;
		}
		return mapper.map(commentVo, CommentDto.class);
	}

	public static List<CommentVo> toVo(List<CommentDto> commentDtos) {
		List<CommentVo> commentVos = new ArrayList<>();
		for (CommentDto commentDto : commentDtos) {
			commentVos.add(toVo(commentDto));
		}
		return commentVos;
	}

	public static List<CommentDto> toDto(List<CommentVo> commentVos) {
		List<CommentDto> commentDtos = new ArrayList<>();
		for (CommentVo commentVo : commentVos) {
			commentDtos.add(toDto(commentVo));
		}
		return commentDtos;
	}

}
