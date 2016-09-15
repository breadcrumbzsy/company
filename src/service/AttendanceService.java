package service;

import java.sql.Date;
import java.util.List;

import dao.AttendanceDao;
import dao.RecordDao;
import domain.Attendance;

public class AttendanceService {

	RecordDao rd=new RecordDao();
	AttendanceDao ad=new AttendanceDao();
	
	public int setIsAllowed(int aid) {
		return ad.setIsAllowed(aid);
	}
	
	public int addDay(String department,Date day_){
		return ad.addDay(department, day_);
	}
	public List<Attendance> findByEidAndMonth(int eid,int year,int month){
		return ad.findByEidAndMonth(eid, year, month);
	}

}
