package com.myapp.login.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.myapp.registration.pojo.RegistrationForm;

@Entity
@Table(name="LOGINDETAILS ")
public class LoginForm {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="LoginId")
	private int loginId;
	
	@OneToOne
	private RegistrationForm registrationForm;
	
	@NotNull
    @Size(min = 2, max = 30)
	@Column(name="USERNAME")
	private String userName;
	
	@NotNull
	@Column(name="PASSWORD")
	private String password;
	
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
	
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public RegistrationForm getRegistrationForm() {
		return registrationForm;
	}
	public void setRegistrationForm(RegistrationForm registrationForm) {
		this.registrationForm = registrationForm;
	}
	public String toString() {
        return "LoginForm(UserName: " + this.userName + ", Password: " + this.password + ")";
    }
}
