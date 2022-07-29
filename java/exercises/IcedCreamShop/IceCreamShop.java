package com.skillstorm.assignments.week4.beans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class IceCreamShop {
	//Fields
	private String name;
	private double amountEarned;
	private ArrayList<IceCream> flavors; // Are the allowed flavors at a given store
	private Queue<Customer> customerLine = new LinkedList<>(); // Represents the line of customers at a given store (Each customer has an ice cream)
	
	/*
	 * The default constructor
	 */
	public IceCreamShop() {
		this.name = "";
		this.amountEarned = 0.0;
		this.flavors = new ArrayList<>();
	}
	
	/*
	 * The overloaded constructor
	 */
	public IceCreamShop(String name) {		
		this();
		this.name = name;
	}
	
	/*
	 * The overloaded constructor
	 */
	public IceCreamShop(String name, ArrayList<IceCream> flavors) {		
		this.name = name;
		this.amountEarned = 0.0;
		if(flavors != null)
			this.flavors = new ArrayList<IceCream>(flavors);
		else
			this.flavors = new ArrayList<IceCream>();
			
	}
	
	/*
	 * TODO
	 * 
	 * This function services the customer at the front of the customer line and adds their total ice cream cost to the line before
	 * removing them from the line.
	 * 
	 * If they do not have an ice cream (null value) throw an IllegalArgumentException
	 * If they have a flavor that's not in the flavors list, throw an IllegalArgumentException
	 * 
	 * HINT: For IceCream comparison, compare the two Ice Cream's String flavors
	 */
	public void serviceCustomer() {
		
		//An exception will be thrown if the line of customer is empty.
		if(customerLine.isEmpty())
			throw new NoSuchElementException("Error: Customer line is empty.");
		
		//An exception will be thrown if there is no more ice cream flavor available.
		if(flavors.isEmpty())
			throw new NoSuchElementException("Error: All of ice cream flavors are out of order.");
		
		//Remove the customer from the line if they don't not know their flavor to purchase.
		if(customerLine.peek().getIceCream() == null) {
			Customer customer= customerLine.remove();
			throw new IllegalArgumentException("Error: The customer " + 
												customer.getName() + " does not have his/her flavor.");
		}
		//Processing the customer's order.
		String customerFlavor = customerLine.peek().getIceCream().getFlavor();
		for(int i = 0; i < flavors.size(); i++) {
			//If the flavor is found, process the order, remove 
			//the flavor from the freezer and remove the customer from the line.
			if(customerFlavor.equalsIgnoreCase(flavors.get(i).getFlavor())) {
				this.amountEarned += flavors.get(i).getPrice();
				customerLine.remove();
				removeFlavor(flavors.get(i));
				return;
			}
			
		}
		
		//If the customer's flavor is not found, remove the customer from the line and
		//and an exception will be thrown.
		customerLine.remove();
		throw new IllegalArgumentException("Error: The customer's flavor " + customerFlavor + " is not available now.");
		
	}
	
	/*
	 * TODO
	 * 
	 * This function adds a customer to the back of the line
	 */
	public void addCustomer(Customer customer) {
		
		if(customer == null)
			throw new NullPointerException("Error: The customer cannot be null");
		
		customerLine.add(customer);		
	}
	
	
	
	/*
	 * TODO
	 * 
	 * This function should add a flavor to the ice cream list
	 * 
	 * HINT: For IceCream comparison, compare the two Ice Cream's String flavors
	 */
	public void addFlavor(IceCream flavor) {
		
		//Check the flavor argument if it is null
		if(flavor == null) {
			throw new NullPointerException("Error: The flavor to be added cannot be null!");
		}
			
		//Check if a duplicate flavor exists before adding it to the array 
		for(int i = 0; i < this.flavors.size(); i++) {
			if(flavor.getFlavor().equalsIgnoreCase(this.flavors.get(i).getFlavor()))
					throw new IllegalArgumentException("Error: The flavor " + flavor.getFlavor() + " already exists.");
		}
		
		//Add a new flavor to the ice cream store
		this.flavors.add(flavor);
			
	}
	
	/*
	 * TODO
	 * 
	 * This function should remove a flavor from the ice cream list
	 * 
	 * HINT: For IceCream comparison, compare the two Ice Cream's String flavors
	 */
	public void removeFlavor(IceCream flavor) {
		
		if(flavor == null)
			throw new NullPointerException("Error: The flavor to be removed cannot be null!");
		
		if(this.flavors.size() == 0) 
			throw new IllegalArgumentException("Error: The freeze is empty!");		
		
		for(int i = 0; i < this.flavors.size(); i++) {
			if(flavor.getFlavor().equalsIgnoreCase(this.flavors.get(i).getFlavor())) {
				this.flavors.remove(i);
				return;
			}
		}
		
		throw new IllegalArgumentException("Error: The flavor " + flavor.getFlavor() + " does not exist.");			
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getTotalEarnings() {
		return this.amountEarned;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Available Flavors\n");
		for(int i = 0; i < flavors.size(); i++) {
			string.append(flavors.get(i));
		}
		string.append("\n");
		string.append("Next customer in queue: ");
		if(customerLine.size() == 0)
			string.append("None.\n");
		else	
			string.append(customerLine.peek()+ "\n");
		
		return string.toString();
	}
	
}
