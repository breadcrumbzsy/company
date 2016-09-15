package domain;

import java.sql.Date;

public class Salary {
	private int sid;
	private int eid;
	private int year_;
	private int month_;
	private double basic;
	private double bonus;
	private double penalty;
	private double total;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getYear_() {
		return year_;
	}
	public void setYear_(int year) {
		this.year_ = year;
	}
	public int getMonth_() {
		return month_;
	}
	public void setMonth_(int month) {
		this.month_ = month;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Salary [sid=" + sid + ", eid=" + eid + ", year_=" + year_
				+ ", month_=" + month_ + ", basic=" + basic + ", bonus=" + bonus
				+ ", penalty=" + penalty + ", total=" + total + "]";
	}


}
