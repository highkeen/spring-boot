package com.highken.training.bootlearn.controller.model;

public class Registration {

	private String firstName;
	private String lastName;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

}
