package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.omg.CORBA.UserException;

import service.EmployeeException;
import service.EmployeeService;

public class EmployeeAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EmployeeAdd() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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

		int eid = Integer.valueOf(request.getParameter("eid"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		System.out.println("enroll time"+request.getParameter("enrollTime"));
		Date enrollTime=Date.valueOf(request.getParameter("enrollTime"));
		String level = request.getParameter("level");
		String department = request.getParameter("department");
		String password=request.getParameter("password");
		
		String skill1=request.getParameter("skill1");
		String skill2=request.getParameter("skill2");
		String skill3=request.getParameter("skill3");
		String skill4=request.getParameter("skill4");
		String skill5=request.getParameter("skill5");
		
		String training1=request.getParameter("training1");
		String training2=request.getParameter("training2");
		String training3=request.getParameter("training3");
		String training4=request.getParameter("training4");
		String training5=request.getParameter("training5");
		
		List<String> skill=new ArrayList<String>();
		if(skill1!=null)
			skill.add(skill1);
		if(skill2!=null)
			skill.add(skill2);
		if(skill3!=null)
			skill.add(skill3);
		if(skill4!=null)
			skill.add(skill4);
		if(skill5!=null)
			skill.add(skill5);
		List<String> training=new ArrayList<String>();
		if(training1!=null)
			training.add(training1);
		if(training2!=null)
			training.add(training2);
		if(training3!=null)
			training.add(training3);
		if(training4!=null)
			training.add(training4);
		if(training5!=null)
			training.add(training5);
		
		System.out.println(skill);
		System.out.println(training);
		
		JSONObject json=new JSONObject();
		int result=0;
		
		try {
			result = employeeService.add(eid, name, gender, email, tel, enrollTime, level,department, 0, password, skill, training);
			json.put("result", Integer.valueOf(result));
		} catch (Exception e) {
			json.put("result", Integer.valueOf(result));
			e.printStackTrace();
		}
		response.getWriter().write(json.toString());
		System.out.println(json.toString());
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
