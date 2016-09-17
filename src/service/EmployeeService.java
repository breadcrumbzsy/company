package service;

import java.sql.Date;
import java.util.List;

import dao.EmployeeDao;
import domain.Employee;

public class EmployeeService {
	private EmployeeDao ed=new EmployeeDao();
	
	public Employee login(int eid,String password){
		Employee e=ed.findByEid(eid);
		if(e.getPassword().equals(password)){
			return e;
		}else
			return null;
		
	}
	
	public int add(int eid, String name, String gender, String email,String tel, Date enrollTime, String level,String department, int isQuit,String password,List<String> skills,List<String> trainings){
		int result=ed.add(eid, name, gender, email, tel, enrollTime, level,department, isQuit,password);
		int result1=ed.addSkills(eid, skills);
		int result2=ed.addTrainings(eid, trainings);
		if(result==1&&result1==1&&result2==1)
			return 1;
		else
			return 0;
	}

	public int modify(int eid,String email, String tel, String level,
			String department, int isQuit) {
		return ed.modifyInfo(eid, email, tel, level, department, isQuit);
	}
	public int modifyPassword(int eid,String oldPassword,String newPassword) {
		Employee e=ed.findByEid(eid);
		if(e.getPassword().equals(oldPassword)){
			return ed.modifyPassword(eid, newPassword);
		}
		return 0;
	}

	public int addSkill(int eid,String description) {
		return ed.addSkill(eid, description);
	}
	public int deleteSkill(int sklid) {
		return ed.deleteSkill(sklid);
	}
	public int addTraining(int eid,String description) {
		return ed.addTraining(eid, description);
	}
	public int deleteTraining(int tid) {
		return ed.deleteTraining(tid);
	}
	
	
	public List<Employee> findByDepartment(String department) {
		return ed.findByDepartment(department);
	}
	public List<Employee> findByName(String name) {
		return ed.findByName(name);
	}
	public Employee findByEid(int eid){
		return ed.findByEid(eid);
	}
	
	public int quit(int eid){
		return ed.quit(eid);
	}
	
	//=========================================
	public List<Employee> findByBoss() {
		return ed.findByBoss();
	}
	
}
