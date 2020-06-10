package by.htp.service247.domain;

public class Act {
	private int id_act;
	private String time;
	private String comment;
	private int id_contractor;
	private String describtion;
	private int id_demand;
	
	public Act() {

	}

	public Act(int id_act, String time, String comment,int id_contractor,String describtion,int id_demand) {
		super();
		this.id_act = id_act;
		this.time = time;
		this.comment= comment;
		this.id_contractor= id_contractor;
		this.describtion = describtion;
		this.id_demand = id_demand;
	}

	public int getId_act() {
		return id_act;
	}

	public void setId_act(int id_act) {
		this.id_act = id_act;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getId_contractor() {
		return id_contractor;
	}

	public void setId_contractor(int id_contractor) {
		this.id_contractor = id_contractor;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public int getId_demand() {
		return id_demand;
	}

	public void setId_demand(int id_demand) {
		this.id_demand = id_demand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((describtion == null) ? 0 : describtion.hashCode());
		result = prime * result + id_act;
		result = prime * result + id_contractor;
		result = prime * result + id_demand;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Act other = (Act) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (describtion == null) {
			if (other.describtion != null)
				return false;
		} else if (!describtion.equals(other.describtion))
			return false;
		if (id_act != other.id_act)
			return false;
		if (id_contractor != other.id_contractor)
			return false;
		if (id_demand != other.id_demand)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	
	
	

}
