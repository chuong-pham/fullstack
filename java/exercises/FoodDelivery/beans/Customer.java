package com.skillstorm.assignments.week6.FoodDelivery.beans;

/*
 * The class holds general information about a customer
 */
public class Customer {
	//Properties
	private String name;
	private String phoneNumber;
	
	/**
	 * The default constructor
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * The overloaded constructor
	 * @param name
	 * @param phoneNumber
	 */
	public Customer(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
