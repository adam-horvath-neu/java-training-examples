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
@WebServlet("/AutocompleteServlet")
public class AutocompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutocompleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String term = request.getParameter("term");

		ArrayList<Helper> helpers = new ArrayList<Helper>();
		helpers.add(new Helper("AAAA label", "A"));
		helpers.add(new Helper("BBBB label", "B"));
		helpers.add(new Helper("CCCC label", "C"));
		helpers.add(new Helper("DDDD label", "D"));
		helpers.add(new Helper("EEEE label", "E"));

		ArrayList<Helper> rv = new ArrayList<AutocompleteServlet.Helper>();
		for (Helper helper : helpers) {
			if (helper.getLabel().toUpperCase().contains(term.toUpperCase())) {
				rv.add(helper);
			}
		}

		Gson gson = new Gson();
		gson.toJson(rv, response.getWriter());

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
		private String label;
		private String value;

		public Helper(String label, String value) {
			super();
			this.label = label;
			this.value = value;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}
