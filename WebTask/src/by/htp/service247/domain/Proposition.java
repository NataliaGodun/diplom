package by.htp.service247.domain;

public class Proposition {
	private int id_proposition;
	private String name_user;
	private String email_user;
	private String phone_user;
	private String department;
	private String city;
	private int km;
	private int radiator;
	private int reber_radiatorov;
	private int area;
	private int price;
	
	public Proposition() {

	}

	public Proposition(int id_proposition, String name_user, String email_user,String phone_user,String department,String city, int km,int radiator,int reber_radiatorov,int area, int price) {
		super();
		this.id_proposition = id_proposition;
		this.name_user = name_user;
		this.email_user= email_user;
		this.phone_user = phone_user;
		this.department = department;
		this.city = city;
		this.km = km;
		this.radiator = radiator;
		this.reber_radiatorov = reber_radiatorov;
		this.area = area;
		this.price = price;

	}
	public int getId_proposition() {
		return id_proposition;
	}
	public void setId_proposition(int id_proposition) {
		this.id_proposition = id_proposition;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public String getEmail_user() {
		return email_user;
	}
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	public String getPhone_user() {
		return phone_user;
	}
	public void setPhone_user(String phone_user) {
		this.phone_user = phone_user;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getRadiator() {
		return radiator;
	}
	public void setRadiator(int radiator) {
		this.radiator = radiator;
	}
	public int getReber_radiatorov() {
		return reber_radiatorov;
	}
	public void setReber_radiatorov(int reber_radiatorov) {
		this.reber_radiatorov = reber_radiatorov;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + area;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((email_user == null) ? 0 : email_user.hashCode());
		result = prime * result + id_proposition;
		result = prime * result + km;
		result = prime * result + ((name_user == null) ? 0 : name_user.hashCode());
		result = prime * result + ((phone_user == null) ? 0 : phone_user.hashCode());
		result = prime * result + price;
		result = prime * result + radiator;
		result = prime * result + reber_radiatorov;
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
		Proposition other = (Proposition) obj;
		if (area != other.area)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (email_user == null) {
			if (other.email_user != null)
				return false;
		} else if (!email_user.equals(other.email_user))
			return false;
		if (id_proposition != other.id_proposition)
			return false;
		if (km != other.km)
			return false;
		if (name_user == null) {
			if (other.name_user != null)
				return false;
		} else if (!name_user.equals(other.name_user))
			return false;
		if (phone_user == null) {
			if (other.phone_user != null)
				return false;
		} else if (!phone_user.equals(other.phone_user))
			return false;
		if (price != other.price)
			return false;
		if (radiator != other.radiator)
			return false;
		if (reber_radiatorov != other.reber_radiatorov)
			return false;
		return true;
	}


}
