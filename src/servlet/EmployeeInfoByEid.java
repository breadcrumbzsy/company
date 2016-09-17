package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.EmployeeService;
import domain.Employee;
import domain.Skill;
import domain.Training;

public class EmployeeInfoByEid extends HttpServlet {

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
		int eid=Integer.valueOf(request.getParameter("eid"));
		String department=request.getParameter("department");
	

		Employee employee = es.findByEid(eid);
		JSONObject json=new JSONObject();
		
		Employee bmjl=(Employee) request.getSession().getAttribute("employee");
		if(eid!=bmjl.getEid()){
			JSONArray skillArray = new JSONArray();
			JSONArray trainingArray = new JSONArray();
			List<Skill> skillList=employee.getSkill();
			List<Training> trainingList=employee.getTraining();
			System.out.println(skillList);
			System.out.println(trainingList);
			for(int i=0;i<skillList.size();i++){
				Skill skill=skillList.get(i);
				JSONObject obj = new JSONObject();
				obj.put("sklid", skill.getSklid());
				obj.put("eid", skill.getEid());
				obj.put("description", skill.getDescription());
				skillArray.add(obj);
			}
			for(int i=0;i<trainingList.size();i++){
				Training  training =trainingList.get(i);
				JSONObject obj = new JSONObject();
				obj.put("tid", training.getTid());
				obj.put("eid", training.getEid());
				obj.put("description", training.getDescription());
				trainingArray.add(obj);
			}
			
			if(employee.getDepartment().equals(department)||department.equals("董事会")){
				json.put("eid", employee.getEid());
				json.put("name", employee.getName());
				json.put("gender", employee.getGender());
				json.put("email", employee.getEmail());
				json.put("tel", employee.getTel());
				json.put("enrollTime", employee.getEnrollTime().toString());
				json.put("level", employee.getLevel());
				json.put("department", employee.getDepartment());
				if(employee.getIsQuit()==0){
					json.put("shifouzaizhi", "是");
				}else{
					json.put("shifouzaizhi", "否");
				}
				json.put("skillArray", skillArray);
				json.put("trainingArray", trainingArray);
				
			}
		}
		//skill&training
		System.out.println("EmployeeInfoByEid:"+json.toString());
		response.getWriter().write(json.toString());
	}

}
