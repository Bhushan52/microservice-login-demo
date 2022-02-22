package com.appdeveloperblog.phtoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message = "First Name should not be null")
	@Size(min =2, message = "First Name should not be less then two charachters")
	private String firstName;
	
	@NotNull(message = "Last Name should not be null")
	@Size(min =2, message = "Last Name should not be less then two charachters")
	private String lastName;
	
	@NotNull(message = "Password should not be null")
	private String password;
	
	@Email(message = "Enter valid email-id")
	private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
