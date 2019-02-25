package bean;

public class Staff {
	
	private int staffId;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String address;
	private String telephoneNumber;
	private String emailId;
	private String password;
	
	/*******************Getters and Setters************************/	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**************************toString Method***************************************/	
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + ", address=" + address + ", telephoneNumber=" + telephoneNumber
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}
}
