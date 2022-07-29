package com.skillstorm.assignments.week6.FoodDelivery.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * The class holds and manages details about a customer's order
 */
public class Order implements Comparable<Order>{
	//Properties
	private static int orderNumber = 0;
	private int orderID;
	private LocalDateTime orderTime;
	private LocalDateTime completeTime;
	private Map<Item, Integer> orderedItems;
	private Customer customer;
	private double totalPrice;
	
		
	/**
	 * The default constructor
	 */
	public Order() {
		super();
	}

	/**
	 * The overloaded constructor
	 * @param customer The customer placing an order
	 */
	public Order(Customer customer) {
		super();
		this.orderID = ++orderNumber;
		this.orderTime = LocalDateTime.now();
		this.completeTime = null;
		this.orderedItems = new HashMap<>();
		this.customer = customer;
		this.totalPrice = 0;
	}
		
	/**
	 * The method returns the customer who placed the order
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * The method stores the information of the customer
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * The method returns the id number of the current order
	 * @return the orderID
	 */
	public int getOrderID() {
		return orderID;
	}
	
	/**
	 * The method returns the time when the order was placed
	 * @return the orderTime
	 */
	public String getOrderTime() {
		return formatDateTime(this.orderTime);
	}
	
	/**
	 * The method allows to set the time when an order will be placed
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}	

	/**
	 * The method returns the time when the order will have been finished
	 * @return the completeTime
	 */
	public String getCompleteTime() {
		if(this.completeTime == null)
			throw new NullPointerException("Error: The complete time cannot be null");
		else
			return formatDateTime(this.completeTime);
	}
	
	/*
	 * The method allows to set the time when an order will be completed
	 * @param completeTime the completeTime to set
	 */
	public void setCompleteTime(LocalDateTime completeTime) {
		if(completeTime.isBefore(this.orderTime))
			throw new IllegalArgumentException("Error: Invalid complete date time");
		
		this.completeTime = completeTime;	
	}
	
	/*
	 * The method formats the system date time to be human-readable format
	 * @param unformatted The unformatted date time
	 * @return the formatted date time ("dd-mm-yyyy hh:mm:ss")
	 */
	private String formatDateTime(LocalDateTime unformatted) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatted = unformatted.format(format); 
		return formatted;
	}

	/*
	 * The method collects and adds order's details of a customer to the system
	 * @param item The food and drink item to be added
	 * @param amount The number units of the item to to be added
	 */
	public void addItem(Item item, int amount) {
		
		if(item == null)
			throw new NullPointerException("Error: An item cannot be null");
		
		if(amount <= 0)
			throw new IllegalArgumentException("Error: Invalid amount of items");
		
		if(!orderedItems.containsKey(item))
			orderedItems.put(item, amount);	
		else {
			//If a customer add the same item again, simply increases the amount of that item.
			orderedItems.put(item, orderedItems.get(item) + amount);
		}
	}
	
	/*
	 * The method allows to remove a complete specified item from the current order
	 * @param item The item to be removed
	 * @return true if the specified item exists, otherwise it returns false
	 */
	public boolean removeItem(Item item) {
		boolean result = false;
		if(item == null) 
			throw new NullPointerException("Error: An item cannot be null");
		
		if(orderedItems.containsKey(item)) {
			orderedItems.remove(item);
			result = true;
		}		
		return result;		
	}
	
	/*
	 * The method allows to change the amount units of an specified item
	 * @param item The specified item
	 * @param newAmount The new amount units to be changed
	 */	
	public boolean editItemAmount(Item item, int newAmount) {
		boolean result = false;
		if(item == null)
			throw new NullPointerException("Error: An item cannot be null");
		
		if(newAmount <= 0)
			throw new IllegalArgumentException("Error: Invalid amount of items");
		
		if(orderedItems.containsKey(item)) {
			orderedItems.replace(item, newAmount);
			result = true;
		}
		return result;
	}
	
	/*
	 * The method returns the total price of the current order which
	 * includes subtotal plus a possible delivery cost if the order 
	 * completes less than one hour
	 * @return the total price of the specified order
	 */
	public double getTotalPrice() {	
		this.totalPrice = this.getSubTotal() + this.getDeliveryCost();
		return this.totalPrice;
	}
	
	/*
	 * The method simply calculates the subtotal of a specified order
	 * @return the subtotal of a specified order
	 */
	private double getSubTotal() {
		double subTotal = 0;
		for(Item item : orderedItems.keySet()) {
			subTotal += item.getUnitPrice() * orderedItems.get(item);
		}
		
		return subTotal;
	}
	
	/*
	 * The method calculates the delivery cost depending on how long 
	 * the specified order will complete
	 * @return the delivery cost of the order
	 */
	private double getDeliveryCost() {
		double deliveryCost = 0.0;
		if(this.completeTime == null)
			throw new NullPointerException("Error: The complete time cannot be null!");
		long processingTime = this.orderTime.until(this.completeTime, ChronoUnit.MINUTES);
		
		if(processingTime < 60) {
			deliveryCost = 7.25 * (60 - processingTime)/60;
		}
		return deliveryCost;
	}
	
	/*
	 * The method returns the details of the current order
	 * @return the order's details
	 */
	public String toString() {
		StringBuilder orderDetail = new StringBuilder();
		
		orderDetail.append("ORDER#" + this.getOrderID()+"\n");
		orderDetail.append("START:\t" + this.getOrderTime() +"\n");
		orderDetail.append("FINISH:\t" + this.getCompleteTime() +"\n");
		orderDetail.append(this.getCustomer().getName() + "\t");
		orderDetail.append(this.getCustomer().getPhoneNumber());
		orderDetail.append("\n\n");
		
		for(Item item : orderedItems.keySet()) {
			int amount = orderedItems.get(item);
			double unitPrice = item.getUnitPrice();
			orderDetail.append(String.format("%-5d %-15s $%-9.2f $%-9.2f\n", amount, item.getName().toString(), item.getUnitPrice(), amount*unitPrice));
		}
		
		orderDetail.append(String.format("\n%-32s $%5.2f", "Subtotal", this.getSubTotal()));
		orderDetail.append(String.format("\n%-32s $%5.2f", "Delivery", this.getDeliveryCost()));
		orderDetail.append(String.format("\n%-32s $%5.2f\n", "Total", this.getTotalPrice()));
		return orderDetail.toString();
		
	}

	
	
	/*
	 * The method compares the time placing order between two orders
	 * @param other The other order's time to compare
	 * @return -1 if this order is before the other. Otherwise, it returns 1
	 */
	@Override
	public int compareTo(Order other) {
		// TODO Auto-generated method stub
		if(this.completeTime == null || other.completeTime == null)
			throw new NullPointerException("Error: Complete time cannot be null");
		
		if(this.orderTime.isBefore(other.orderTime))
			return -1;
		if(this.orderTime.isAfter(other.orderTime))
			return 1;
		else
			return 0;
	}
	
}
