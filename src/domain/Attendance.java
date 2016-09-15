package domain;

import java.sql.Date;

public class Attendance {
	private int aid;
	private int eid;
	private String name;
	private Date day;
	private int isLate;
	private int isAbsent;
	private int isAllowed;
	private double penalty;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public int getIsLate() {
		return isLate;
	}
	public void setIsLate(int isLate) {
		this.isLate = isLate;
	}
	public int getIsAbsent() {
		return isAbsent;
	}
	public void setIsAbsent(int isAbsent) {
		this.isAbsent = isAbsent;
	}
	public int getIsAllowed() {
		return isAllowed;
	}
	public void setIsAllowed(int isAllowed) {
		this.isAllowed = isAllowed;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Attendance [aid=" + aid + ", eid=" + eid + ", name=" + name
				+ ", day=" + day + ", isLate=" + isLate + ", isAbsent="
				+ isAbsent + ", isAllowed=" + isAllowed + ", penalty="
				+ penalty + "]";
	}


}
