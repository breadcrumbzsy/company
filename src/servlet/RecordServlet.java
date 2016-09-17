package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.RecordService;

public class RecordServlet extends HttpServlet {

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
		int eid=Integer.valueOf(request.getParameter("eid"));
	
		RecordService rs=new RecordService();
		int lastType=rs.findLastType(eid);
		int result=rs.sign(eid);
		System.out.println("lastType"+lastType);
		JSONObject json=new JSONObject();
		if(result==1&&lastType>3){
			json.put("msg", "签退成功");
		}else if(result==1&&lastType==1){
			json.put("msg", "签到成功");
		}else{
			json.put("msg", "系统错误，请重试！");
		}
		System.out.println(json.toString());
		response.getWriter().write(json.toString());
	}

}
