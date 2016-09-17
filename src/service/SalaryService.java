package service;

import java.util.ArrayList;
import java.util.List;

import javassist.expr.NewArray;
import dao.AttendanceDao;
import dao.EmployeeDao;
import dao.SalaryDao;
import domain.Employee;
import domain.Salary;

public class SalaryService {
	//试用员工、普通员工、组长、部门经理、总经理
	static double syyg=3000.00;
	static double ptyg=6000.00;
	static double zz=8000.00;
	static double bmjl=10000.00;
	static double zjl=12000.00;
	
	private EmployeeDao ed=new EmployeeDao();
	private AttendanceDao ad=new AttendanceDao();
	private SalaryDao sd=new SalaryDao();
	
	public int setBasic(double syyg,double ptyg,double zz,double bmjl,double zjl){
		this.syyg=syyg;
		this.ptyg=ptyg;
		this.zz=zz;
		this.bmjl=bmjl;
		this.zjl=zjl;
		//System.out.println(this.syyg,this.ptyg,this.zz,this.bmjl,this.zjl);
		return 1;
	}
	
	public int setTotal(int eid,int year,int month,double bonus){
		
		double basic = 0;
		Employee e=ed.findByEid(eid);
		String level=e.getLevel();
		
		if(level.equals("试用员工"))
			basic=syyg;
		if(level.equals("普通员工"))
			basic=ptyg;	
		if(level.equals("组长"))
			basic=zz;	
		if(level.equals("部门经理"))
			basic=bmjl;	
		if(level.equals("总经理"))
			basic=zjl;	
		
		return sd.addSalary(eid, year, month, basic, bonus);
	}
	
	public List<Salary> findByEidAndYear(int eid,int year) {
		return sd.findByEidAndYear(eid, year);
	}
	
	public List<Salary> findByMonth(String department,int year,int month) {
		return sd.findByMonth(department, year, month);
	}
	public List<Salary> findByEid(String department,int eid) {
		return sd.findByEid(department, eid);
	}
	public List<Salary> findByMonthBoss(int year,int month) {
		return sd.findByMonthBoss( year, month);
	}
	public List<Salary> findByEidBoss(int eid) {
		return sd.findByEidBoss( eid);
	}
	
	public List<Employee> findSalaryUnset(String department,int year,int month) {
		List<Employee> employeeList=ed.findByDepartment(department);
		List<Employee> list=new ArrayList<Employee>();
		for(int i=0;i<employeeList.size();i++){
			Employee employee=employeeList.get(i);
			List<Salary> salaries =sd.findByEidAndMonth(employee.getEid(), year, month);
			if(salaries.size()==0||salaries==null){
				list.add(employee);
			}
		}
		return list;
	}
	
	public List<Employee> findSalaryUnsetBoss(int year,int month) {
		List<Employee> employeeList=ed.findDeptMng();
		List<Employee> list=new ArrayList<Employee>();
		for(int i=0;i<employeeList.size();i++){
			Employee employee=employeeList.get(i);
			List<Salary> salaries =sd.findByEidAndMonth(employee.getEid(), year, month);
			if(salaries.size()==0||salaries==null){
				list.add(employee);
			}
		}
		return list;
	}
}
