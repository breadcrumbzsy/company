package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javassist.compiler.Javac;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Attendance;
import domain.AttendanceCount;
import domain.Employee;
import domain.Record;

public class AttendanceDao {
	private QueryRunner qr = new TxQueryRunner();
	EmployeeDao ed=new EmployeeDao();
	RecordDao rd=new RecordDao();
	

	
	public int addDay(String department,Date day_) throws NumberFormatException, ParseException {
		List<Employee> employeeList=ed.findByDepartment(department);
		System.out.println("employeeList:"+employeeList);
		
		for(int i=0;i<employeeList.size();i++){
			Employee employee=employeeList.get(i);
			if(!employee.getLevel().equals("部门经理")){
				int eid;
				Date day;
				int isAbsent;
				int isLate;
				double penalty;
				eid=employee.getEid();

				day=day_;
				
				List<Record> recordList=rd.findByEidAndDay(eid, day);
				System.out.println("recordList:"+recordList);
				System.out.println("eid="+eid+";isTimeLongEnough+"+isTimeLongEnough(recordList));
				if(recordList.size()==0){
					isAbsent=1;
					isLate=0;	
					penalty=200;//缺勤罚款200
				}else if(Integer.valueOf(recordList.get(0).getInTime().toString().substring(0, 2))>=10){
					isAbsent=1;
					isLate=1;
					penalty=200;//迟到2h以上算成缺勤罚款200
				}else if(isTimeLongEnough(recordList)==false){
					isAbsent=1;
					isLate=0;
					penalty=200;//就算没有迟到2h以上，不足6小时算成缺勤罚款200
				}else if(Integer.valueOf(recordList.get(0).getInTime().toString().substring(0, 2))>=8){
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
		}
		return 1;
	}
	public int addDayBoss(Date day_) throws NumberFormatException, ParseException {
		List<Employee> employeeList=ed.findDeptMng();
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
			}else if(Integer.valueOf(recordList.get(0).getInTime().toString().substring(0, 2))>=10){
				isAbsent=1;
				isLate=1;
				penalty=200;//迟到2h以上算成缺勤罚款200
			}else if(isTimeLongEnough(recordList)==false){
				isAbsent=1;
				isLate=0;
				penalty=200;//就算没有迟到2h以上，不足6小时算成缺勤罚款200
			}else if(Integer.valueOf(recordList.get(0).getInTime().toString().substring(0, 2))>=8){
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
	
	public List<Attendance> findByEid(int eid,String department) {
		try {
			//还要修改
			String sql = "select * from attendance ,employee  where attendance.eid=employee.eid and employee.eid=? and department=? order by employee.eid";
			List<Attendance> attendanceList = (List<Attendance>) this.qr.query(sql, new BeanListHandler<Attendance>(
					Attendance.class), new Object[] {eid,department});
			return attendanceList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Attendance> findByEidBoss(int eid) {
		try {
			//还要修改
			String sql = "select * from attendance ,employee  where attendance.eid=employee.eid and employee.eid=? order by employee.eid";
			List<Attendance> attendanceList = (List<Attendance>) this.qr.query(sql, new BeanListHandler<Attendance>(
					Attendance.class), new Object[] {eid});
			return attendanceList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Attendance> findByDay(Date day,String department) {
		try {
			//还要修改
			String sql = "select * from attendance ,employee  where attendance.eid=employee.eid and attendance.day=? and department=? order by employee.eid";
			List<Attendance> attendanceList = (List<Attendance>) this.qr.query(sql, new BeanListHandler<Attendance>(
					Attendance.class), new Object[] {day,department});
			return attendanceList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Attendance> findByDayBoss(Date day) {
		try {
			//还要修改
			String sql = "select * from attendance ,employee  where attendance.eid=employee.eid and attendance.day=? and employee.level='部门经理' order by employee.eid";
			List<Attendance> attendanceList = (List<Attendance>) this.qr.query(sql, new BeanListHandler<Attendance>(
					Attendance.class), new Object[] {day});
			return attendanceList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public AttendanceCount getAttendenceCountMonthlyById(int eid,int year,int month){
		try {
			String sql = "select * from attendance,employee where attendance.eid=employee.eid and attendance.day like ? and employee.eid=? and attendance.isAllowed=0";
			String yearmonth;
			if(month<10)
				yearmonth=year+"-0"+month+"%";
			else		
				yearmonth=year+"-"+month+"%";
			List<Attendance> attendanceList = (List<Attendance>) this.qr.query(sql, new BeanListHandler<Attendance>(
					Attendance.class), new Object[] {yearmonth,eid});
			
			AttendanceCount ac=new AttendanceCount();
			ac.setEid(eid);
			ac.setYear(year);
			ac.setMonth(month);
			
			double penalty=0;
			int countLate=0;
			int countAbsent=0;
			for(int i=0;i<attendanceList.size();i++){
				Attendance attendance=attendanceList.get(i);
				
				ac.setName(attendance.getName());
				
				penalty=penalty+attendance.getPenalty();
				
				if(attendance.getIsAbsent()==1)
					countAbsent++;
				if(attendance.getIsAbsent()==0&&attendance.getIsLate()==1)
					countLate++;
			}
			
			ac.setCountLate(countLate);
			ac.setCountAbsent(countAbsent);
			ac.setPenalty(penalty);
			return ac;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	private Boolean isTimeLongEnough(List<Record> recordList) throws ParseException{
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long allTime = 0;
		for(int i=0;i<recordList.size();i++){
			if(recordList.get(i).getOutTime()!=null){
				java.util.Date begin = dfs.parse("2000-01-01 "+recordList.get(i).getInTime().toString()+".000");
				java.util.Date end = dfs.parse("2000-01-01 "+recordList.get(i).getOutTime().toString()+".000");
				long period=end.getTime()-begin.getTime();
				allTime=allTime+period;
			}
		}
		long day = allTime / (24 * 60 * 60 * 1000);
		long hour = (allTime / (60 * 60 * 1000) - day * 24);
		if(hour>=6)
			return true;
		return false;
	}




}
