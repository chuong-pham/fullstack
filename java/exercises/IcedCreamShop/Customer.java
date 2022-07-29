package com.skillstorm.assignments.week4.beans;

public class Customer {

	private IceCream iceCream;
	private String name;
	
	public Customer() {}

	public Customer(String name, IceCream flavor) {
		this.name = name;
		this.iceCream = flavor;
	}

	public IceCream getIceCream() {
		return iceCream;
	}

	public void setIceCream(IceCream flavor) {
		this.iceCream = flavor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		if(this.iceCream == null)
			return this.name + " - Unknown flavor";
		else
			return this.name + "-" + this.iceCream.getFlavor(); 
	}
}
