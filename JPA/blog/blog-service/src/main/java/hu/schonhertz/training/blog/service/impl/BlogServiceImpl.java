package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonhertz.training.blog.dao.client.BlogDao;
import hu.schonhertz.training.blog.dto.client.BlogDto;
import hu.schonhertz.training.blog.service.BlogService;
import hu.schonhertz.training.blog.service.mapper.BlogMapper;
import hu.schonhertz.training.blog.vo.BlogVo;

@Stateless
@Local(BlogService.class)
public class BlogServiceImpl implements BlogService {

	static final Log logger = LogFactory.getLog(BlogServiceImpl.class);
	@EJB
	private BlogDao blogDao;

	@Override
	public List<BlogVo> getAllBlog() {
		List<BlogDto> blogDtos = null;
		try {
			blogDtos = blogDao.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BlogMapper.toVo(blogDtos);
	}

	@Override
	public BlogVo getBlogById(Integer id) {
		BlogDto blogDto = null;
		try {
			blogDto = blogDao.find(id.longValue());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return BlogMapper.toVo(blogDto);
	}

	@Override
	public void createBlog(BlogVo blogVo) {
		try {
			blogDao.save(BlogMapper.toDto(blogVo));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
