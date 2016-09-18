package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.EmployeeService;
import domain.Employee;

public class EmployeeInfoByNameB extends HttpServlet {

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
		
		EmployeeService es=new EmployeeService();
		String name=request.getParameter("name");
		//String department=request.getParameter("department");
		
		
		JSONArray array = new JSONArray();
		List<Employee> list = es.findByName(name);
		for (int i = 0; i< list.size(); i++) {
			Employee employee = list.get(i);
			
			if(employee.getEid()!=1000){
				
				JSONObject obj = new JSONObject();
				obj.put("eid", employee.getEid());
				obj.put("name", employee.getName());
				obj.put("gender", employee.getGender());
				obj.put("email", employee.getEmail());
				obj.put("tel", employee.getTel());
				obj.put("enrollTime", employee.getEnrollTime().toString());
				obj.put("level", employee.getLevel());
				obj.put("department", employee.getDepartment());
				if(employee.getIsQuit()==0){
					obj.put("shifouzaizhi", "是");
				}else{
					obj.put("shifouzaizhi", "否");
				}
				array.add(obj);
			}
		}
		JSONObject json = new JSONObject();
		json.put("array", array);
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
	}

}
