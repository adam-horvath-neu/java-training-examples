package hu.schonhertz.training.blog.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mindrot.jbcrypt.BCrypt;

import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.vo.UserVo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String LOGIN_JSP_URL = "login.jsp";

	private static Log logger = LogFactory.getLog(LoginServlet.class);

	@EJB
	private UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LoginForm loginForm = new LoginForm(request);

		String username = loginForm.getUsername();

		UserVo user = null;

		try {
			user = userService.findUserByName(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user == null) {
			request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
			request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			return;
		}

		if (user != null) {
			String password = loginForm.getPassword();
			
			boolean check = BCrypt.checkpw(password, user.getPassword());
			
			if (check) {
				request.getSession().setAttribute("user", user);
				response.sendRedirect("index.jsp");

			} else {
				request.setAttribute("error", "Hibás felhasználónév vagy jelszó!");
				request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher(LOGIN_JSP_URL).forward(request, response);
	}
}
