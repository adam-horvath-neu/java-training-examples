package hu.neuron.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.neuron.service.UserService;
import hu.neuron.service.impl.UserServiceImpl;
import hu.neuron.service.vo.UserVo;

@WebServlet("/registration")
public class Registration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (password != null && !password.equals(password2)) {
			request.setAttribute("ERROR", "Jelszó nem egyezik!");
		}

		UserService service = new UserServiceImpl();
		UserVo vo = new UserVo();
		vo.setUsername(request.getParameter("username"));
		vo.setPassword(password);
		service.registration(vo);

		request.setAttribute("OK", Boolean.TRUE);

		request.getRequestDispatcher("registration.jsp").forward(request, response);

	}
}
