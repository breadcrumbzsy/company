package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.RecordService;
import domain.Employee;
import domain.Record;

public class AttendanceRecordListByEid extends HttpServlet {

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
		
		String department=request.getParameter("department");
		int eid=Integer.valueOf(request.getParameter("eid"));
		
		JSONArray array = new JSONArray();
		List<Record> list = rs.findByEid(eid, department);
		for (int i = 0; i < list.size(); i++) {
			Record record = list.get(i);
			JSONObject obj = new JSONObject();
			obj.put("rid", record.getRid());
			obj.put("eid", record.getEid());
			obj.put("name", record.getName());
			obj.put("day", record.getDay().toString());
			obj.put("inTime", record.getInTime().toString());
			if(record.getOutTime()!=null)
				obj.put("outTime", record.getOutTime().toString());
			else {
				obj.put("outTime", null);
			}
			
			array.add(obj);

		}
		JSONObject json = new JSONObject();
		json.put("array", array);
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
	}
}
