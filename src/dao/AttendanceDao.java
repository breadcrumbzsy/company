package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Attendance;
import domain.Employee;
import domain.Record;

public class AttendanceDao {
	private QueryRunner qr = new TxQueryRunner();
	EmployeeDao ed=new EmployeeDao();
	RecordDao rd=new RecordDao();
	

	
	public int addDay(String department,Date day_) {
		List<Employee> employeeList=ed.findByDepartment(department);
		System.out.println("employeeList:"+employeeList);
		for(int i=0;i<employeeList.size();i++){
			int eid;
			Date day;
			int isAbsent;
			int isLate;
			double penalty;
			
			Employee employee=employeeList.get(i);
			eid=employee.getEid();

			day=day_;
			
			List<Record> recordList=rd.findByEidAndDay(eid, day);
			System.out.println("recordList:"+recordList);
			if(recordList.size()==0){
				isAbsent=1;
				isLate=0;	
				penalty=200;//缺勤罚款200
			}else if(Integer.valueOf(recordList.get(recordList.size()-1).getInTime().toString().substring(0, 2))>10){
				isAbsent=1;
				isLate=1;
				penalty=200;//迟到2h以上算成缺勤罚款200
			}else if(Integer.valueOf(recordList.get(recordList.size()-1).getInTime().toString().substring(0, 2))>8){
				isAbsent=0;
				isLate=1;
				penalty=50;//迟到罚款50
			}else{
				isAbsent=0;
				isLate=0;
				penalty=0;//wu 
			}
			System.out.println("isAbsent:"+isAbsent);
			System.out.println("isLate:"+isLate);
			System.out.println("penalty:"+penalty);
			try {
				String sql = "insert into attendance(eid,day,isAbsent,isLate,penalty) values(?,?,?,?,?)";
				Object[] params = {eid,day,isAbsent,isLate,penalty};
				this.qr.update(sql, params);
				System.out.println("ok");
				
			} catch (SQLException e) {
				System.out.println("wrong");
				e.printStackTrace();
			}

		}
		return 1;
	}
	
	public int setIsAllowed(int aid) {
		try {
			String sql= "update attendance set isAllowed=1,penalty=0 where aid=? ";
			this.qr.update(sql,aid);
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}
	
	//部门经理设定这个department的工资
	public double getPenaltyMonthly(int eid,int year,int month){
		try {
			String sql = "select * from attendance where day like ? and eid=?";
			String yearmonth;
			if(month<10)
				yearmonth=year+"-0"+month+"%";
			else		
				yearmonth=year+"-"+month+"%";
			List<Attendance> attendanceList = (List<Attendance>) this.qr.query(sql, new BeanListHandler<Attendance>(
					Attendance.class), new Object[] {yearmonth,eid});
			System.out.println("attendanceList:"+attendanceList);
			double penalty=0;
			for(int i=0;i<attendanceList.size();i++){
				penalty=penalty+attendanceList.get(i).getPenalty();
			}
			return penalty;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Attendance> findByEidAndMonth(int eid,int year,int month) {
		try {
			String sql = "select * from attendance where day like ? and eid=?";
			String yearmonth;
			if(month<10)
				yearmonth=year+"-0"+month+"%";
			else		
				yearmonth=year+"-"+month+"%";
			List<Attendance> attendanceList = (List<Attendance>) this.qr.query(sql, new BeanListHandler<Attendance>(
					Attendance.class), new Object[] {yearmonth,eid});
			System.out.println("attendanceList:"+attendanceList);
			return attendanceList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
