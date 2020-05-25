package by.htp.service247.domain;

public class Department {

	private String department;
	private String department_descr;
	private String  services;
	
	public Department() {

	}
	public Department( String department,String  department_descr, String  services) {
		super();
		this.department = department;
		this. department_descr =  department_descr;
		this.services = services;
			
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartment_descr() {
		return department_descr;
	}
	public void setDepartment_descr(String department_descr) {
		this.department_descr = department_descr;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((department_descr == null) ? 0 : department_descr.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
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
		Department other = (Department) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (department_descr == null) {
			if (other.department_descr != null)
				return false;
		} else if (!department_descr.equals(other.department_descr))
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		return true;
	}


	

}
