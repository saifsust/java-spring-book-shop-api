package org.woadec.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.woadec.migrations.Migrate;

@Entity
@Table(name = Migrate.REGISTER_CLIENT)
public class RegisterClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "register_client_id")
	private int registerClientId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "client_password")
	private String clientPassword;
	@Column(name = "image_link")
	private String imageLink;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "zela_id")
	private int zeladId;
	@Column(name = "devision_id")
	private int devisionId;
	@Column(name = "thana_id")
	private int thanaId;
	@Column(name = "location")
	private String location;
	@Column(name = "post_office_code")
	private int postOfficeCode;

	public RegisterClient() {
		super();
	}

	public RegisterClient(String firstName, String lastName, String email, String clientPassword, String imageLink,
			String phoneNumber, int zeladId, int devisionId, int thanaId, String location, int postOfficeCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.clientPassword = clientPassword;
		this.imageLink = imageLink;
		this.phoneNumber = phoneNumber;
		this.zeladId = zeladId;
		this.devisionId = devisionId;
		this.thanaId = thanaId;
		this.location = location;
		this.postOfficeCode = postOfficeCode;
	}



	public int getRegisterClientId() {
		return registerClientId;
	}

	public void setRegisterClientId(int registerClientId) {
		this.registerClientId = registerClientId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getZeladId() {
		return zeladId;
	}

	public void setZeladId(int zeladId) {
		this.zeladId = zeladId;
	}

	public int getDevisionId() {
		return devisionId;
	}

	public void setDevisionId(int devisionId) {
		this.devisionId = devisionId;
	}

	public int getThanaId() {
		return thanaId;
	}

	public void setThanaId(int thanaId) {
		this.thanaId = thanaId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPostOfficeCode() {
		return postOfficeCode;
	}

	public void setPostOfficeCode(int postOfficeCode) {
		this.postOfficeCode = postOfficeCode;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	@Override
	public String toString() {
		return "RegisterClient [registerClientId=" + registerClientId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", clientPassword=" + clientPassword + ", imageLink=" + imageLink
				+ ", phoneNumber=" + phoneNumber + ", zeladId=" + zeladId + ", devisionId=" + devisionId + ", thanaId="
				+ thanaId + ", location=" + location + ", postOfficeCode=" + postOfficeCode + "]";
	}

	

}
