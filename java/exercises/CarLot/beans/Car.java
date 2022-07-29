package com.skillstorm.assignments.week5.car_lot.beans;

import java.util.Random;

public class Car extends Vehicle {
	//Properties
	private String VIN;
	private CarCondition condition;
	private int mileage;
	private double price;
		
	/**
	 * The overloaded constructor
	 * @param make
	 * @param model
	 * @param year
	 */
	public Car(String make, String model, int year, CarCondition condition, double price) {
		super(make, model, year);
		this.condition =condition;
		this.price = price;
		this.mileage = 0;	
		this.VIN = generateVIN();
	}

	/**
	 * @return the condition
	 */
	public CarCondition getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(CarCondition condition) {
		this.condition = condition;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		if(mileage >= 0)
			this.mileage = mileage;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {		
		if(price > 0) 
			this.price = price;
	}

	/**
	 * @return the VIN
	 */
	public String getVIN() {
		return VIN;
	}

	/**
	 * @param VIN the VIN to set
	 */
	public void setVin(String VIN) {
		this.VIN = VIN;
	}

	@Override
	/*
	 * The method generates a random vehicle 
	 * identification number 
	 */
	protected String generateVIN() {
		StringBuilder vin = new StringBuilder();
		Random random = new Random();
		int randomNumber = 100000 + random.nextInt(100000);
		vin.append(this.getCondition());
		vin.append(this.getMake().charAt(0));
		vin.append(this.getModel().charAt(0));
		vin.append(this.getYear());
		vin.append(randomNumber);
		return vin.toString();
	}

	@Override
	public String toString() {
		String priceFormat = String.format("$%,.2f", this.getPrice());
		String string = this.getCondition() + " " + this.getMake() + " " + 
						this.getModel() + " " + this.getYear() + " " + priceFormat;
		return string;	
	}
	
	
	
	
}
