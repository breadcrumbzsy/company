package domain;

public class AttendanceCount {
	private  int eid;
	private String name;
	private int year;
	private int month;
	private int countLate;
	private int countAbsent;
	private double penalty;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getCountLate() {
		return countLate;
	}
	public void setCountLate(int countLate) {
		this.countLate = countLate;
	}
	public int getCountAbsent() {
		return countAbsent;
	}
	public void setCountAbsent(int countAbsent) {
		this.countAbsent = countAbsent;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	@Override
	public String toString() {
		return "AttendanceCount [eid=" + eid + ", name=" + name + ", year="
				+ year + ", month=" + month + ", countLate=" + countLate
				+ ", countAbsent=" + countAbsent + ", penalty=" + penalty + "]";
	}
	
	
		

}
