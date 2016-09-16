package domain;

public class Training {
	private int tid;
	private int eid;
	private String description;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "Training [tid=" + tid + ", eid=" + eid + ", description="
				+ description + "]";
	}

}
