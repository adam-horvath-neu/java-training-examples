package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.CommentVo;


public interface CommentService {
	@Deprecated
	public List<CommentVo> getAllCommentByBlogId(Integer blogId);

	@Deprecated
	public void createComment(CommentVo commentVo);

	public void addCommnet(CommentVo commentVo, Integer blogId);
}
