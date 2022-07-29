package com.skillstorm.assignments.week4.beans;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * The class holds data of an ice cream
 */
public class IceCream {
	//Fields
	private String flavor;
	private double price;
	
	/*
	 * The default constructor
	 */
	public IceCream() {
		this.flavor = "";
		this.price = 0.0;
	}
	
	/*
	 * The overloaded constructor
	 */
	public IceCream(String flavor, double price) {
		this.flavor = flavor;
		this.price = price;
	}

	/*
	 * The method returns the ice cream flavor
	 */
	public String getFlavor() {
		return this.flavor;
	}

	/*
	 * The method sets the ice cream flavor
	 */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	/*
	 * The method returns the ice cream price
	 */
	public double getPrice() {
		return this.price;
	}

	/*
	 * The method sets the ice cream price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/*
	 * The method returns ice cream data as a String
	 */
	public String toString() {
		String string = String.format("-%-20s$%-5.2f\n" , this.flavor, this.price);	
		return string;
	}
}
