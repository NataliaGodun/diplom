package by.htp.service247.domain;

import java.io.Serializable;

public class Contractor implements Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = -5544827707949518716L;
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String dateOfBirth;
	//private int id_contract_contractor;
	private String login;
	private String password;
	private String status;
	private String role;
	private String department;

	public Contractor() {

	}

	public Contractor(int id, String firstName, String lastName,String phone,String dateOfBirth,String login, String password,String status,String role,String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.login = login;
		this.password = password;
		this.status = status;
		this.role = role;
		this.department = department ;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
	
	
}
