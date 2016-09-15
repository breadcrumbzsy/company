package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.AttendanceService;

public class AttendanceAdd extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AttendanceService as = new AttendanceService();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");


		Date day = Date.valueOf(request.getParameter("day"));
		String department = request.getParameter("department");
		
		JSONObject json=new JSONObject();
		int result=0;
		
		try {
			result = as.addDay(department, day);
			json.put("result", Integer.valueOf(result));
		} catch (Exception e) {
			json.put("result", Integer.valueOf(result));
			e.printStackTrace();
		}
		response.getWriter().write(json.toString());
		System.out.println(json.toString());
	}

}
