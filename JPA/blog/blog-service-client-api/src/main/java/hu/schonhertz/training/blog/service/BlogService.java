package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.BlogVo;

public interface BlogService {

	public List<BlogVo> getAllBlog();

	public BlogVo getBlogById(Integer id);

	public void createBlog(BlogVo blogVo);

}
