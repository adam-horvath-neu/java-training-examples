package hu.neuron.java.param;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet(value = "/ForwardByParam", initParams = {
		@WebInitParam(name = "LOGGER_PREFIX", value = "web:ForwardByParam:"),

})
public class ForwardByParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(ForwardByParam.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForwardByParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");

		String prefix = (String) getInitParameter("LOGGER_PREFIX");

		logger.debug(prefix + "before forward");

		request.getRequestDispatcher(page).forward(request, response);

		logger.debug(prefix + "after forward");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
