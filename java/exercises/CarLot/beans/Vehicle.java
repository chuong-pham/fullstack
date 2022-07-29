package com.skillstorm.assignments.week5.car_lot.beans;

/*
 * The class holds general characteristics of a vehicle
 */
public abstract class Vehicle {
	//Properties
	private String make;
	private String model;
	private int year;
	

	/**
	 * The overloaded constructor
	 * @param make
	 * @param model
	 * @param year
	 */
	public Vehicle(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	
	
	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", year=" + year + "]";
	}

	/*
	 * The abstract method to generate a 
	 * vehicle identification number
	 * @return the vehicle identification number
	 */
	protected abstract String generateVIN();
	
	
}
