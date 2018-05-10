package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;

import hu.schonhertz.training.blog.service.BlogService;
import hu.schonhertz.training.blog.service.CommentService;
import hu.schonhertz.training.blog.vo.BlogVo;
import hu.schonhertz.training.blog.vo.CommentVo;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

	private static final long serialVersionUID = -3759352952465316112L;

	@EJB
	CommentService commentService;

	@EJB
	BlogService blogService;

	@PostConstruct
	public void postConstruct() {
		System.out.println("postconstruct has run.");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		CommentVo commentVo = new CommentVo();
		commentVo.setComment(request.getParameter("comment"));

		Integer blogId = Integer.valueOf(request.getParameter("blogId"));

		commentService.addCommnet(commentVo, blogId);

		resp.setContentType("text/html");
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.getWriter().write("OK");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = request.getParameter("blogId");
		if (!StringUtils.isEmpty(parameter)) {

			Integer blogId = Integer.valueOf(parameter);

			BlogVo blogVo = blogService.getBlogById(blogId);
			Set<CommentVo> commentVos = blogVo.getComments();

			resp.setContentType("application/json");
			resp.setStatus(HttpServletResponse.SC_OK);

			Gson gson = new Gson();
			gson.toJson(commentVos, resp.getWriter());
		}
		resp.setContentType("application/json");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
