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
import service.SalaryService;
import domain.Employee;
import domain.Salary;

public class SalaryListByEid extends HttpServlet {

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
		
		String department=request.getParameter("department");
		int eid=Integer.valueOf(request.getParameter("eid"));
		
		JSONArray array = new JSONArray();
		List<Salary> list = ss.findByEid(department, eid);
		for (int i = 0; i < list.size(); i++) {
			Salary salary = list.get(i);
			
			Employee bmjl=(Employee) request.getSession().getAttribute("employee");
			if(salary.getEid()!=bmjl.getEid()){
				JSONObject obj = new JSONObject();
				obj.put("sid", salary.getSid());
				obj.put("eid", salary.getEid());
				obj.put("name", salary.getName());
				obj.put("year", salary.getYear_());
				obj.put("month", salary.getMonth_());
				obj.put("basic", salary.getBasic());
				obj.put("bonus", salary.getBonus());
				obj.put("penalty", salary.getPenalty());
				obj.put("total", salary.getTotal());
				array.add(obj);
			}
			
		}
		JSONObject json = new JSONObject();
		json.put("array", array);
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
	}

}
