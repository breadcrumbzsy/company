package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.EmployeeService;

public class EmployeeModify extends HttpServlet {

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
		EmployeeService employeeService = new EmployeeService();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int eid=Integer.valueOf(request.getParameter("eid"));
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String level = request.getParameter("level");
		String department = request.getParameter("department");
		String shifouzaizhi=request.getParameter("shifouzaizhi");
		int isQuit;
		if(shifouzaizhi.endsWith("是"))
			isQuit=0;
		else
			isQuit=1;
		
		JSONObject json=new JSONObject();
		int result=0;
		
		try {
			result = employeeService.modify(eid,email, tel,level,department, isQuit);
			json.put("result", Integer.valueOf(result));
		} catch (Exception e) {
			json.put("result", Integer.valueOf(result));
			e.printStackTrace();
		}
		response.getWriter().write(json.toString());
		System.out.println(json.toString());

	}

}
