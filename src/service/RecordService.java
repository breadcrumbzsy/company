package service;

import java.sql.Date;
import java.util.List;

import dao.EmployeeDao;
import dao.RecordDao;
import domain.Record;

public class RecordService {
	RecordDao rd=new RecordDao();
	EmployeeDao ed=new EmployeeDao();
	
	public int sign(int eid){
		int lastType=rd.findLastType(eid);
		if(lastType>3){
			return rd.setOutTime(lastType);
		}else if(lastType==1){
			return rd.addRecord(eid);
		}else{
			return 0;
		}
	}
	
	public int findLastType(int eid) {
		return rd.findLastType(eid);
	}
	
	public List<Record> findByEid(int eid,String department){
		return rd.findByEid(eid,department);
	}
	public List<Record> findByEidBoss(int eid){
		return rd.findByEidBoss(eid);
	}
	
	public List<Record> findByDay(Date day,String department){
		return rd.findByDay(day,department);
	}
	public List<Record> findByDayBoss(Date day){
		return rd.findByDayBoss(day);
	}

	public List<Record> findByEidAndMonth(int eid, int year, int month) {
		return rd.findByEidAndMonth(eid, year, month);
	}

}
