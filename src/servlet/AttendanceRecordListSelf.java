package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.AttendanceService;
import service.RecordService;
import domain.Employee;
import domain.Record;

public class AttendanceRecordListSelf extends HttpServlet {

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
		
		RecordService rs=new RecordService();
		
		Employee e=(Employee)request.getSession().getAttribute("employee");
		int eid=e.getEid();
		int year=Integer.valueOf(request.getParameter("year"));
		int month=Integer.valueOf(request.getParameter("month"));
		
		
		System.out.println(year+"年"+month+"月");
		JSONArray array = new JSONArray();
		List<Record> list = rs.findByEidAndMonth(eid,year,month);
		for (int i = 0; i < list.size(); i++) {
			Record record = list.get(i);
			JSONObject obj = new JSONObject();
			obj.put("rid", record.getRid());
			obj.put("eid", record.getEid());
			obj.put("day", record.getDay().toString());
			obj.put("inTime", record.getInTime().toString());
			obj.put("outTime", record.getOutTime().toString());
			
			array.add(obj);

		}
		JSONObject json = new JSONObject();
		json.put("array", array);
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
	}

}
