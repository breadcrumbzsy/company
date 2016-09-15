package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.AttendanceService;
import domain.Attendance;
import domain.Record;

public class AttendanceListByDay extends HttpServlet {

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
		
		AttendanceService as=new AttendanceService();
		
		String department=request.getParameter("department");
		Date day=Date.valueOf(request.getParameter("day"));
		
		JSONArray array = new JSONArray();
		List<Attendance> list=as.findByDay(day, department);
		for (int i = 0; i < list.size(); i++) {
			Attendance a = list.get(i);
			JSONObject obj = new JSONObject();
			obj.put("aid",a.getAid() );
			obj.put("eid", a.getEid());
			obj.put("name", a.getName());
			obj.put("day", a.getDay().toString());
			if( a.getIsLate()==1)
				obj.put("isLate","是");
			else
				obj.put("isLate","否");
			if(a.getIsAbsent()==1)
				obj.put("isAbsent","是");
			else
				obj.put("isAbsent","否");
			if(a.getIsAllowed()==1)
				obj.put("isAllowed","是");
			else
				obj.put("isAllowed","否");
			
			obj.put("penalty", a.getPenalty());
			
			array.add(obj);

		}
		JSONObject json = new JSONObject();
		json.put("array", array);
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
	}

}
