package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.EmployeeService;
import domain.Employee;

public class EmployeeQuit extends HttpServlet {

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
		EmployeeService es = new EmployeeService();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int eid=Integer.valueOf(request.getParameter("eid"));	
		
		JSONObject json=new JSONObject();
		int result=0;
		
		try {
			result = es.quit(eid);
			json.put("result", Integer.valueOf(result));
		} catch (Exception ex) {
			json.put("result", Integer.valueOf(result));
			ex.printStackTrace();
		}
		//response.getWriter().write(json.toString());
		if(result==1)
			response.getWriter().write("设置成功!");
		else
			response.getWriter().write("设置失败!");
		System.out.println(json.toString());
	}

}
