package domain;

import java.sql.Date;
import java.util.List;

public class Employee {
	private int eid;
	private String name;
	private String gender;
	private String email;
	private String tel;
	private Date enrollTime;
	private String level;
	//技术部，人事部，财务部，后勤部
	private String department;
	private int isQuit;
	private String password;
	
	private List<Skill> skill;
	private List<Training> training;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getEnrollTime() {
		return enrollTime;
	}
	public void setEnrollTime(Date enrollTime) {
		this.enrollTime = enrollTime;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getIsQuit() {
		return isQuit;
	}
	public void setIsQuit(int isQuit) {
		this.isQuit = isQuit;
	}
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	public List<Training> getTraining() {
		return training;
	}
	public void setTraining(List<Training> training) {
		this.training = training;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", gender=" + gender
				+ ", email=" + email + ", tel=" + tel + ", enrollTime="
				+ enrollTime + ", level=" + level + ", department="
				+ department + ", isQuit=" + isQuit + ", password=" + password
				+ ", skill=" + skill + ", training=" + training + "]";
	}


}
