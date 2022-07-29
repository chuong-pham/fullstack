package com.skillstorm.assignments.week6.FoodDelivery.beans;

/*
 * The class holds detail information of a single item
 */
public class Item {
	//Properties
	private MenuItem name;
	private double unitPrice;
	
	/**
	 * The default constructor
	 */
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * The overloaded constructor
	 * @param name
	 * @param unitPrice
	 */
	public Item(MenuItem name, double unitPrice) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the name
	 */
	public MenuItem getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(MenuItem name) {
		this.name = name;
	}

	/**
	 * @return the unitPrice
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", unitPrice=" + unitPrice + "]";
	}	
}
