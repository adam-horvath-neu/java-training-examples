package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.BlogService;
import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.vo.BlogVo;
import hu.schonhertz.training.blog.vo.UserVo;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
	private static Log logger = LogFactory.getLog(BlogServlet.class);
	private static final long serialVersionUID = 1795959081410371020L;

	@EJB
	BlogService blogService;

	@EJB
	UserService userService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		BlogVo blogVo = new BlogVo();
		UserVo curerntUser = (UserVo) request.getSession().getAttribute("user");
		try {
			curerntUser = userService.findUserByName(curerntUser.getUserName());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		blogVo.setCreator(curerntUser);
		blogVo.setTitle(request.getParameter("title"));
		blogVo.setText(request.getParameter("text"));

		blogService.createBlog(blogVo);

		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write("OK");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		String parameter = request.getParameter("blogId");

		if (StringUtils.isEmpty(parameter)) {
			List<BlogVo> blogVos = blogService.getAllBlog();

			resp.setContentType("application/json");
			resp.setStatus(HttpServletResponse.SC_OK);

			Gson gson = new Gson();
			gson.toJson(blogVos, resp.getWriter());
		} else {
			Integer blogId = Integer.valueOf(parameter);
			BlogVo blogVo = blogService.getBlogById(blogId);

			resp.setContentType("application/json");
			resp.setStatus(HttpServletResponse.SC_OK);

			Gson gson = new Gson();
			gson.toJson(blogVo, resp.getWriter());
		}
	}
}
