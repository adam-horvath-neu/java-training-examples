package hu.schonhertz.training.blog.dao.mapper;

import java.util.HashSet;
import java.util.Set;

import hu.schonhertz.training.blog.dto.client.BlogDto;
import hu.schonhertz.training.blog.dto.client.CommentDto;
import hu.schonhertz.training.blog.entity.Blog;
import hu.schonhertz.training.blog.entity.Comment;

public class BlogMapper {

	public static Blog toEntity(BlogDto dto, Blog entity) {
		Blog ret = entity;
		if (dto.getId() == null || entity == null) {
			ret = new Blog();

		}
		ret.setId(dto.getId());
		ret.setText(dto.getText());
		ret.setTitle(dto.getTitle());

		ret.setCreator(UserMapper.toEntity(dto.getCreator(), null));

		Set<CommentDto> commentDtos = dto.getComments();

		if (commentDtos != null && !commentDtos.isEmpty()) {
			Set<Comment> comments = new HashSet<>();
			for (CommentDto commentDto : commentDtos) {
				comments.add(CommentMapper.toEntity(commentDto, null));
			}

			ret.setComments(comments);
		}

		return ret;

	}

	public static BlogDto toDto(Blog entity) {
		BlogDto ret = new BlogDto();
		if (entity == null) {
			return null;

		}
		ret.setId(entity.getId());
		ret.setText(entity.getText());
		ret.setTitle(entity.getTitle());

		ret.setCreator(UserMapper.toDto(entity.getCreator()));

		Set<Comment> comments = entity.getComments();

		if (comments != null && !comments.isEmpty()) {
			Set<CommentDto> commentDtos = new HashSet<>();
			for (Comment comment : comments) {
				commentDtos.add(CommentMapper.toDto(comment));
			}
			ret.setComments(commentDtos);
		}
		return ret;
	}

}
