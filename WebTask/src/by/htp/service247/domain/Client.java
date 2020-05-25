package by.htp.service247.domain;

public class Client {
	//private static final long serialVersionVID=-8544827707949518716L;
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String status;
	private String login;
	private String password;
	private String servSant;
	private String servElectr;
	private String servVent;

	

	
	public Client() {

	}
	public Client(int id, String email,String firstName,String lastName,String phone,String address,String status,String login, String password,String servSant,String servElectr,String servVent) {
	
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone= phone;
		this.address = address;
		this.status = status;
		//this.id_contract_customer = id_contract_customer;
		this.login = login;
		this.password = password;
		this.servSant = servSant;
		this.servElectr = servElectr;
		this.servVent = servVent;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getServSant() {
		return servSant;
	}
	public void setServSant(String servSant) {
		this.servSant = servSant;
	}
	public String getServElectr() {
		return servElectr;
	}
	public void setServElectr(String servElectr) {
		this.servElectr = servElectr;
	}
	public String getServVent() {
		return servVent;
	}
	public void setServVent(String servVent) {
		this.servVent = servVent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((servElectr == null) ? 0 : servElectr.hashCode());
		result = prime * result + ((servSant == null) ? 0 : servSant.hashCode());
		result = prime * result + ((servVent == null) ? 0 : servVent.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (servElectr == null) {
			if (other.servElectr != null)
				return false;
		} else if (!servElectr.equals(other.servElectr))
			return false;
		if (servSant == null) {
			if (other.servSant != null)
				return false;
		} else if (!servSant.equals(other.servSant))
			return false;
		if (servVent == null) {
			if (other.servVent != null)
				return false;
		} else if (!servVent.equals(other.servVent))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}	
	


	
}