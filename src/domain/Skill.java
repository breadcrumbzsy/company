package domain;

public class Skill {
	private int eid;
	private String describe;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "Skill [eid=" + eid + ", describe=" + describe + "]";
	}
	
}
