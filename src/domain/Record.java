package domain;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Record {
	private int rid;
	private int eid;
	private String name;
	private Date day;
	private Time inTime;
	private Time outTime;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Time getInTime() {
		return inTime;
	}
	public void setInTime(Time inTime) {
		this.inTime = inTime;
	}
	public Time getOutTime() {
		return outTime;
	}
	public void setOutTime(Time outTime) {
		this.outTime = outTime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Record [rid=" + rid + ", eid=" + eid + ", name=" + name
				+ ", day=" + day + ", inTime=" + inTime + ", outTime="
				+ outTime + "]";
	}


	

}
