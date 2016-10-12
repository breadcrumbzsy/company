package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import domain.Record;

public class RecordDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Record> findByEidAndDay(int eid, Date day) {
		try {
			// 还要修改
			String sql = "select * from record where eid=? and day=? order by inTime";
			List<Record> recordList = (List<Record>) this.qr.query(sql,
					new BeanListHandler<Record>(Record.class), new Object[] {
							eid, day.toString() });
			return recordList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Record> findByEid(int eid, String department) {
		try {
			// 还要修改
			String sql = "select * from record ,employee  where record.eid=employee.eid and employee.eid=? and department=? order by inTime";
			List<Record> recordList = (List<Record>) this.qr.query(sql,
					new BeanListHandler<Record>(Record.class), new Object[] {
							eid, department });
			return recordList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Record> findByEidBoss(int eid) {
		try {
			// 还要修改
			String sql = "select * from record ,employee  where record.eid=employee.eid and employee.eid=? order by inTime";
			List<Record> recordList = (List<Record>) this.qr.query(sql,
					new BeanListHandler<Record>(Record.class),
					new Object[] { eid });
			return recordList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Record> findByDay(Date day, String department) {
		try {
			// 还要修改
			String sql = "select * from record ,employee  where record.eid=employee.eid and record.day=? and department=? order by inTime";
			List<Record> recordList = (List<Record>) this.qr.query(sql,
					new BeanListHandler<Record>(Record.class), new Object[] {
							day, department });
			return recordList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Record> findByDayBoss(Date day) {
		try {
			// 还要修改
			String sql = "select * from record ,employee  where record.eid=employee.eid and record.day=? order by inTime";
			List<Record> recordList = (List<Record>) this.qr.query(sql,
					new BeanListHandler<Record>(Record.class),
					new Object[] { day });
			return recordList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Record> findByEidAndMonth(int eid, int year, int month) {
		try {
			String sql = "select * from record where day like ? and eid=?";
			String yearmonth;
			if (month < 10)
				yearmonth = year + "-0" + month + "%";
			else
				yearmonth = year + "-" + month + "%";
			List<Record> recordList = (List<Record>) this.qr.query(sql,
					new BeanListHandler<Record>(Record.class), new Object[] {
							yearmonth, eid });
			System.out.println("recordList:" + recordList);
			return recordList;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int findLastType(int eid) {
		// 0表示签到，1表示签退，2表示系统错误
		try {
			long now = System.currentTimeMillis();
			Date CurrTime = new Date(now);
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			String day = dateformat.format(CurrTime);
			String sql = "select * from record where eid =? and day=? order by inTime desc";
			List<Record> list = qr.query(sql,new BeanListHandler(Record.class),new Object[] { eid, day });
			if (list == null || list.size() == 0) {
				return 1;
			} else {
				Time outTime = list.get(0).getOutTime();
				System.out.println("outtime:" + outTime);
				if (outTime == null)
					return list.get(0).getRid();
				else
					return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
	}

	//添加一条新的记录（签到）
	public int addRecord(int eid) {
		try {
			Timestamp inTime = new Timestamp(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date d1 = sdf.parse(inTime.toString()); // 先把字符串转为util.Date对象
			java.sql.Date date = new java.sql.Date(d1.getTime()); // 再转换为sql.Date对象
			System.out.println("time:" + inTime.toString());
			System.out.println("date:" + date.toString());
			String sql = "insert into record (eid,day,inTime) values (?,?,?)";
			Object[] params = { eid, date, inTime };
			qr.update(sql, params);
			System.out.println("ok");
			return 1;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	//给签退时间字段赋值（签退）
	public int setOutTime(int rid) {
		try {
			Timestamp outTime = new Timestamp(System.currentTimeMillis());
			System.out.println("time:" + outTime.toString());

			String sql = "update record set outTime=? where rid=?";
			this.qr.update(sql, new Object[] { outTime, rid });
			System.out.println("ok");
			return 1;
		} catch (SQLException e) {
			System.out.println("wrong");
			e.printStackTrace();
		}
		return 0;
	}

}
