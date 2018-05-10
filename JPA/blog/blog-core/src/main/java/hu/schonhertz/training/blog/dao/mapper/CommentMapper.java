package hu.schonhertz.training.blog.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.dto.client.CommentDto;
import hu.schonhertz.training.blog.entity.Comment;

public class CommentMapper {

	public static Comment toEntity(CommentDto dto, Comment entity) {
		Comment ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new Comment();

		}
		ret.setId(dto.getId());
		ret.setComment(dto.getComment());

		return ret;
	}

	public static CommentDto toDto(Comment entity) {
		CommentDto ret = new CommentDto();
		if (entity == null) {
			return null;
		}
		ret.setId(entity.getId());
		ret.setComment(entity.getComment());

		return ret;
	}

}
