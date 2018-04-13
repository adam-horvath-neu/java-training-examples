package hu.neuron.java.simple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/TableContentServlet")
public class TableContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TableContentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String[] locales = Locale.getISOCountries();

		ArrayList<Helper> arrayList = new ArrayList<Helper>();
		for (String countryCode : locales) {

			Locale locale = new Locale("", countryCode);
			arrayList.add(new Helper(countryCode, locale.getDisplayName(),
					locale.getDisplayLanguage(), locale.getDisplayCountry()));
		}
		Gson gson = new Gson();
		response.setCharacterEncoding("UTF-8");
		gson.toJson(new Response(arrayList), response.getWriter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static class Response {
		private ArrayList<Helper> data;

		public Response(ArrayList<Helper> data) {
			super();
			this.data = data;
		}

		public ArrayList<Helper> getData() {
			return data;
		}

		public void setData(ArrayList<Helper> data) {
			this.data = data;
		}

	}

	public static class Helper {
		private String code;
		private String name;
		private String languange;
		private String country;

		public Helper(String code, String name, String languange, String country) {
			super();
			this.code = code;
			this.name = name;
			this.languange = languange;
			this.country = country;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLanguange() {
			return languange;
		}

		public void setLanguange(String languange) {
			this.languange = languange;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

	}

}
