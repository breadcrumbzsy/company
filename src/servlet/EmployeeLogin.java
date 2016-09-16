package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.omg.CORBA.UserException;

import service.EmployeeService;
import domain.Employee;

public class EmployeeLogin extends HttpServlet {

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

		EmployeeService es = new EmployeeService();
		int eid = Integer.valueOf(request.getParameter("eid"));
		String password = request.getParameter("password");
		
		JSONObject json = new JSONObject();
		int result = 0;
		try {
			Employee employee = es.login(eid, password);
			if (employee != null&&employee.getIsQuit()==0){
				if(employee.getLevel().equals("总经理")){
					result=1;
				}else if(employee.getLevel().equals("部门经理")){
					result=2;
				}else{
					result=3;
				}
			}	
			else {
				result = 0;
			}
			request.getSession().setAttribute("employee", employee);
			json.put("result", Integer.valueOf(result));
			System.out.println(employee);
		} catch (Exception e) {
			json.put("result", Integer.valueOf(result));
			e.printStackTrace();
			//json.put("msg", e.getMessage());
		}
		
		response.getWriter().write(json.toString());
		System.out.println(json.toString());
	}

}
