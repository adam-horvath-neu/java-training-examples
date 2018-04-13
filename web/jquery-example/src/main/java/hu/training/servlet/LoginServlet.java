package hu.training.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Map<String, String> users;
	
	static {
		users = new HashMap<String, String>();
		users.put("Adam", "Jelszo");
		users.put("Bela", "Jelszo");
		users.put("Zsolt", "Jelszo");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: " + username + ", Password: " + password);
		
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		Response resp = new Response();
		
		String pw = users.get(username);
		if (pw != null && pw.equals(password)) {
			resp.setSuccess(true);
		} 
		
		System.out.println("Response: " + gson.toJson(resp));
		
		gson.toJson(resp, response.getWriter());
	}

	public static class Response {
		private boolean success;

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}
	}

}
