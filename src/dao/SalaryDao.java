package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Record;
import domain.Salary;

public class SalaryDao {

	
	private QueryRunner qr = new TxQueryRunner();
	AttendanceDao ad=new AttendanceDao();
	
	public int addSalary(int eid,int year,int month,double basic, double bonus) {
		try {
			double penalty=ad.getPenaltyMonthly(eid, year, month);
			System.out.println("penalty:"+penalty);
			String sql = "insert into salary(eid,year_,month_,basic,bonus,penalty,total) values(?,?,?,?,?,?,?)";
			Object[] params = { eid,year,month,basic,bonus,penalty,(basic+bonus-penalty)};
			this.qr.update(sql, params);
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Salary> findByEidAndYear(int eid,int year) {
		try {
			String sql = "select * from salary where year_=? and eid=?";
			List<Salary> salaryList = (List<Salary>) this.qr.query(sql, new BeanListHandler<Salary>(
					Salary.class), new Object[] {year,eid});
			System.out.println("salaryList:"+salaryList);
			return salaryList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public List<Salary> findByEidAndMonth(int eid,int year,int month) {
		try {
			String sql = "select * from salary where year_=? and month_=? and eid=?";
			List<Salary> salaryList = (List<Salary>) this.qr.query(sql, new BeanListHandler<Salary>(
					Salary.class), new Object[] {year,month,eid});
			System.out.println("salaryList:"+salaryList);
			return salaryList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Salary> findByMonth(String department,int year,int month) {
		try {
			String sql = "select * from salary,employee where salary.eid=employee.eid and salary.year_=? and salary.month_=? and employee.department=?";
			List<Salary> salaryList = (List<Salary>) this.qr.query(sql, new BeanListHandler<Salary>(
					Salary.class), new Object[] {year,month,department});
			System.out.println("salaryList:"+salaryList);
			return salaryList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Salary> findByEid(String department,int eid) {
		try {
			String sql = "select * from salary,employee where salary.eid=employee.eid and employee.eid=? and employee.department=?";
			List<Salary> salaryList = (List<Salary>) this.qr.query(sql, new BeanListHandler<Salary>(
					Salary.class), new Object[] {eid,department});
			System.out.println("salaryList:"+salaryList);
			return salaryList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
