package domain;

public class Skill {
	private int sklid;
	private int eid;
	private String description;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getSklid() {
		return sklid;
	}
	public void setSklid(int sklid) {
		this.sklid = sklid;
	}
	@Override
	public String toString() {
		return "Skill [sklid=" + sklid + ", eid=" + eid + ", description="
				+ description + "]";
	}

}
