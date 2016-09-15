package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.SalaryService;

public class SalaryBasicModify extends HttpServlet {

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

		SalaryService ss = new SalaryService();

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		double syyg=Double.valueOf(request.getParameter("syyg"));
		double ptyg=Double.valueOf(request.getParameter("ptyg"));
		double zz=Double.valueOf(request.getParameter("zz"));
		double bmjl=Double.valueOf(request.getParameter("bmjl"));
		double zjl=Double.valueOf(request.getParameter("zjl"));
		

		JSONObject json=new JSONObject();
		int result=0;
		
		try {
			result = ss.setBasic(syyg, ptyg, zz, bmjl, zjl);
			json.put("result", Integer.valueOf(result));
		} catch (Exception e) {
			json.put("result", Integer.valueOf(result));
			e.printStackTrace();
		}
		response.getWriter().write(json.toString());
		System.out.println(json.toString());
	}

}
