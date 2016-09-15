package service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.AttendanceDao;
import dao.EmployeeDao;
import dao.RecordDao;
import domain.Attendance;
import domain.AttendanceCount;
import domain.Employee;

public class AttendanceService {

	RecordDao rd=new RecordDao();
	AttendanceDao ad=new AttendanceDao();
	EmployeeDao ed=new EmployeeDao();
	
	public int setIsAllowed(int aid) {
		return ad.setIsAllowed(aid);
	}
	
	public int addDay(String department,Date day_){
		return ad.addDay(department, day_);
	}
	public List<Attendance> findByEidAndMonth(int eid,int year,int month){
		return ad.findByEidAndMonth(eid, year, month);
	}

	public List<Attendance> findByEid(int eid,String department){
		
		return ad.findByEid(eid,department);
	}
	
	
	public List<Attendance> findByDay(Date day,String department){
		return ad.findByDay(day,department);
	}

	public List<AttendanceCount> getAttendanceCountMonthly(int year,int month,String department){
		List<AttendanceCount> attendanceCountList=new ArrayList<AttendanceCount>();
		List<Employee> employeeList=ed.findByDepartment(department);
		for(int i=0;i<employeeList.size();i++){
			Employee employee=employeeList.get(i);
			AttendanceCount ac=ad.getAttendenceCountMonthlyById(employee.getEid(), year, month);
			attendanceCountList.add(ac);
		}
		return attendanceCountList;
	}
}
