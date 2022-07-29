package com.skillstorm.assignments.week6.FoodDelivery.beans;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Restaurant {
	String name;
	double totalEarned;
	Queue<Order> orderQueue;
	
	/**
	 * The default constructor
	 */
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * The overloaded constructor
	 * @param name
	 */
	public Restaurant(String name) {
		super();
		this.name = name;
		this.totalEarned = 0.0;
		orderQueue = new PriorityQueue<>();
	}

	/**
	 * The method returns the restaurant name
	 * @return the name of the restaurant
	 */
	public String getName() {
		return name;
	}

	/**
	 * The method sets the restaurant name
	 * @param name The restaurant name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The method returns the total income of the restaurant
	 * after processing all of the orders
	 * @return the totalEarned
	 */
	public double getTotalEarned() {
		return totalEarned;
	}
	
	public int getTotalOrders() {
		return this.orderQueue.size();
	}
	
	/*
	 * The method allows to add an order to the priority queue of the class 
	 * @param order The order to add to priority queue
	 */
	
	public void addOrder(Order order) {
		if(order == null)
			throw new NullPointerException("Error: Order cannot be null");
		if(orderQueue == null)
			throw new NullPointerException("Error: Order queue cannot be null");
		
		orderQueue.add(order);
	}
	
	/*
	 * The method allows to remove an order from the priority queue 
	 * to delivery and accumulate the total earned for each order.
	 * @return the order ready to delivery
	 */
	public Order makeDelivery() {
		
		if(orderQueue == null)
			throw new NullPointerException("Error: Order queue cannot be null");
		if(orderQueue.isEmpty())
			throw new RuntimeException("Error: The order queue is empty");
		
		Order readyToGoOrder = orderQueue.remove();
		this.totalEarned += readyToGoOrder.getTotalPrice();
		return readyToGoOrder;
	}

	/*
	 * The method allows to print receipt of an specified order
	 * @param order The order to print receipt
	 */
	public void printReceipt(Order order) {
		if(order == null)
			throw new NullPointerException("Error: Order cannot be null");
		System.out.println(order);
	}
	
	/*
	 * The method returns the restaurant's detail information
	 * @return the restaurant's details
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getName() + "\n");
		builder.append(String.format("%-10s $%-5.2f\n" , "TOTAL:",this.getTotalEarned()));
		return builder.toString();
	}
	
}
