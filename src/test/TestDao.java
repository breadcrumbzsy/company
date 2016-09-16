package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.AttendanceDao;
import dao.EmployeeDao;
import dao.RecordDao;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDao ed=new EmployeeDao();
		RecordDao rd=new RecordDao();
		AttendanceDao ad=new AttendanceDao();
//		Employee e=ed.findByEid(1);
//		System.out.println(e);

		String skill1="PS";
		String skill2="前端";
		String skill3="";
		String skill4="";
		String skill5="";
		List<String> skill=new ArrayList<String>();
		skill.add(skill1);
		skill.add(skill2);
		skill.add(skill3);
		skill.add(skill4);
		skill.add(skill5);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//ed.addSkills(1, skill);
		//rd.addRecord(1);
		ad.getPenaltyMonthly(1, 2016, 9);
		
	}

}
