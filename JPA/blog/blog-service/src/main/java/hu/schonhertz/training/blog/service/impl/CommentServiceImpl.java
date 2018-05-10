package hu.schonhertz.training.blog.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonhertz.training.blog.dao.client.BlogDao;
import hu.schonhertz.training.blog.dao.client.CommentDao;
import hu.schonhertz.training.blog.dto.client.BlogDto;
import hu.schonhertz.training.blog.dto.client.CommentDto;
import hu.schonhertz.training.blog.service.CommentService;
import hu.schonhertz.training.blog.service.mapper.CommentMapper;
import hu.schonhertz.training.blog.vo.CommentVo;

@Stateless
@Local(CommentService.class)
public class CommentServiceImpl implements CommentService {

	private static Log logger = LogFactory.getLog(CommentServiceImpl.class);
	@EJB
	CommentDao commentDao;

	@EJB
	BlogDao blogDao;

	@Override
	@Deprecated
	public List<CommentVo> getAllCommentByBlogId(Integer blogId) {
		return null;
	}

	@Override
	public void createComment(CommentVo commentVo) {
		try {
			commentDao.save(CommentMapper.toDto(commentVo));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Override
	public void addCommnet(CommentVo commentVo, Integer blogId) {
		try {
			BlogDto blogDto = blogDao.find(blogId.longValue());

			Set<CommentDto> commentDtos = blogDto.getComments();

			if (commentDtos == null) {
				blogDto.setComments(new HashSet<>());
			}
			blogDto.getComments().add(CommentMapper.toDto(commentVo));

			blogDao.update(blogDto);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}
