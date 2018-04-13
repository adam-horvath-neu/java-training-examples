package hu.neuron.java.simple;

import hu.neuron.java.simple.TableContentServlet.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ForwardServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DataServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		HashMap<Long, Data> db = DbMock.getDb();
		if (op.equals("get")) {

			Response rv = new Response(new ArrayList<Data>(db.values()));
			Gson gson = new Gson();
			response.setCharacterEncoding("UTF-8");
			gson.toJson(rv, response.getWriter());
		} else if (op.equals("add")) {

			String date = request.getParameter("date");
			String name = request.getParameter("name");
			String role = request.getParameter("role");

			Long id = new Long(db.size());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

			try {
				db.put(id, new Data(id, dateFormat.parse(date), name, role));
			} catch (ParseException e) {
				response.getWriter().write("ERROR");
			}
		} else if (op.equals("del")) {
			String id = request.getParameter("id");
			db.remove(new Long(id));
		} else if (op.equals("update")) {

			String idString = request.getParameter("id");
			String date = request.getParameter("date");
			String name = request.getParameter("name");
			String role = request.getParameter("role");

			Long id = new Long(idString);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

			try {
		
				db.put(id, new Data(id, dateFormat.parse(date), name, role));
			} catch (ParseException e) {
				response.getWriter().write("ERROR");
			}
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

	public static class Response {
		private ArrayList<Data> data;

		public Response(ArrayList<Data> data) {
			super();
			this.data = data;
		}

		public ArrayList<Data> getData() {
			return data;
		}

		public void setData(ArrayList<Data> data) {
			this.data = data;
		}

	}

}
