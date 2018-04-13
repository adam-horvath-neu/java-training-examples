package hu.neuron.java.json;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/JSONservlet")
public class JSONservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Helper> helpers = new ArrayList<JSONservlet.Helper>();
		helpers.add(new Helper("A", new Date()));
		helpers.add(new Helper("B", new Date()));
		helpers.add(new Helper("C", new Date()));
		helpers.add(new Helper("D", new Date()));
		helpers.add(new Helper("E", new Date()));

		Gson gson = new Gson();
		gson.toJson(helpers, response.getWriter());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static class Helper {
		private String name;
		private Date age;

		public Helper(String name, Date age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getAge() {
			return age;
		}

		public void setAge(Date age) {
			this.age = age;
		}

	}
}
