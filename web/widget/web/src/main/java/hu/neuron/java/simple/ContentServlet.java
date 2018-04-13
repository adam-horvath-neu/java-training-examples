package hu.neuron.java.simple;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/ContentServlet")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String list = request.getParameter("list");
		String html = request.getParameter("html");
		if (id != null) {
			response.getWriter().write("Hello World! " + id);
		} else if (list != null) {
			ArrayList<Helper> helpers = new ArrayList<Helper>();
			helpers.add(new Helper("A", "A"));
			helpers.add(new Helper("B", "B"));
			helpers.add(new Helper("C", "C"));
			helpers.add(new Helper("D", "D"));
			helpers.add(new Helper("E", "E"));

			Gson gson = new Gson();
			gson.toJson(helpers, response.getWriter());
		} else if (html != null) {
			response.sendRedirect("content/"+html);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static class Helper {
		private String title;
		private String id;

		public Helper(String title, String id) {
			super();
			this.title = title;
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	}

}
