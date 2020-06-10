package by.htp.service247.domain;

public class Demand {
		
	private int id;
	private int id_contractor;
	private int id_client;
	private String status_demand;
	private String  department;
	private String describtion;
	private String photo;
	private String time;
	private String address;
	
	
	public Demand() {
	
	}
	public Demand(int id, int id_contractor, int id_client, String status_demand, String department, String describtion,
			String photo, String time,String address) {
		super();
		this.id = id;
		this.id_contractor = id_contractor;
		this.id_client = id_client;
		this.status_demand = status_demand;
		this.department = department;
		this.describtion = describtion;
		this.photo = photo;
		this.time = time;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_contractor() {
		return id_contractor;
	}
	public void setId_contractor(int id_contractor) {
		this.id_contractor = id_contractor;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getStatus_demand() {
		return status_demand;
	}
	public void setStatus_demand(String status_demand) {
		this.status_demand = status_demand;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescribtion() {
		return describtion;
	}
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((describtion == null) ? 0 : describtion.hashCode());
		result = prime * result + id;
		result = prime * result + id_client;
		result = prime * result + id_contractor;
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((status_demand == null) ? 0 : status_demand.hashCode());
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
		Demand other = (Demand) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (describtion == null) {
			if (other.describtion != null)
				return false;
		} else if (!describtion.equals(other.describtion))
			return false;
		if (id != other.id)
			return false;
		if (id_client != other.id_client)
			return false;
		if (id_contractor != other.id_contractor)
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (status_demand == null) {
			if (other.status_demand != null)
				return false;
		} else if (!status_demand.equals(other.status_demand))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	

	
}
