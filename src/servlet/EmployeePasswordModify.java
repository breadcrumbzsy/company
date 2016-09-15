package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.EmployeeService;
import domain.Employee;

public class EmployeePasswordModify extends HttpServlet {

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

		Employee e=(Employee)request.getSession().getAttribute("employee");
		int eid=e.getEid();
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
	
		
		JSONObject json=new JSONObject();
		int result=0;
		
		try {
			result = employeeService.modifyPassword(eid, oldPassword, newPassword);
			json.put("result", Integer.valueOf(result));
		} catch (Exception ex) {
			json.put("result", Integer.valueOf(result));
			ex.printStackTrace();
		}
		response.getWriter().write(json.toString());
		System.out.println(json.toString());
	}

}
