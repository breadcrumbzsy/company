package domain;

public class Training {
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
		return "Training [eid=" + eid + ", describe=" + describe + "]";
	}
	
}
