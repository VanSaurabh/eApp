package com.myapp.registration.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="RegistrationDetails ")
public class RegistrationForm {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int registrationId;
	
	@NotNull
    @Size(min = 2, max = 30)
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column(name="LASTNAME")
	private String lastName;
	
	@NotNull
	@Column(name="EMAIL")
	private String email;
	
	@NotNull
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;
	
	@NotNull
	@Column(name="DateOfBirth")
	@DateTimeFormat(pattern = "yyyy-dd-mm")
	private Date dateOfBirth ;
	
	@NotNull
	@Column(name="ADDRESS")
	private String address;
	
	@NotNull
	@Size(min=2, max=25)
	@Column(name="USERNAME")
	private String userName;
	
	@NotNull
	@Size(min=6, max= 15)
	@Column(name="Password")
	private String password;
	
	public int getLoginId() {
		return registrationId;
	}

	public void setLoginId(int registrationId) {
		this.registrationId = registrationId;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
        return "RegistrationForm(FirstName: " + this.firstName + ", lastName: " + this.lastName + ", email: " + this.email + " , phoneNumber: " + this.phoneNumber +")";
    }
}
