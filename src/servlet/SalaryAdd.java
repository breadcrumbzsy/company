package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.SalaryService;

public class SalaryAdd extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		SalaryService ss=new SalaryService();
		
		int eid=Integer.valueOf(request.getParameter("eid"));
		int year=Integer.valueOf(request.getParameter("year"));
		int month=Integer.valueOf(request.getParameter("month"));
		double bonus=Double.valueOf(request.getParameter("bonus"));
		
		JSONObject json=new JSONObject();
		int result=0;
		
		try {
			result =ss.setTotal(eid, year, month, bonus);
			json.put("result", Integer.valueOf(result));
		} catch (Exception e) {
			json.put("result", Integer.valueOf(result));
			e.printStackTrace();
		}
		response.getWriter().write(json.toString());
		System.out.println(json.toString());
		
	}

}
