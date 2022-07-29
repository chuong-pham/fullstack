package com.skillstorm.assignments.week5.car_lot.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.skillstorm.assignments.week5.car_lot.interfaces.Searchable;

/*
 * The class manages cars in a car lot by using 
 * hash map data structure
 */
public class CarLot implements Searchable<Car>{
	
	//Properties
	private String name;
	private Map<String, Car> inventory;
	
	/*
	 * The default constructor
	 */
	public CarLot() {
		this.name = "";
		inventory = new HashMap<>();
	}
	
	/*
	 * The overloaded constructor
	 */
	public CarLot(String name) {
		this();
		this.name = name;
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

	/*
	 * The method adds a car to the inventory system
	 * @param car The car object to be added
	 */
	public void addCar(Car car) {
		if(car == null)
			throw new NullPointerException("Error: The car cannot be null.");
		
		String key = car.getVIN();
		if(inventory.containsKey(key))
			throw new IllegalArgumentException("Warning: The car already exists.");
		else
			inventory.put(key, car);
	}
		
	/*
	 * The method removes a car from the inventory system by searching for VIN
	 * @param key The VIN of the car to be removed
	 * @return the previous value associated with key, or null if there was no mapping for key
	 */
	public Car removeCar(String key) {
		Car removedCar = inventory.remove(key);
		if(removedCar == null)
			throw new IllegalArgumentException("Error: The car does not exist.");
		else
			return removedCar;
	}
	
	/*
	 * The method counts the total number of available car in the inventory system
	 * @return the total number of cars in the inventory system
	 */
	public int getTotalCars() {
		return inventory.size();
	}

	/*
	 * The method filters a list of cars based on keyword
	 * @param keyword A keyword to search for cars
	 * @return a list of cars that matching the keyword
	 */
	@Override
	public List<Car> filter(String keyword) {
		List<Car> resultList = new ArrayList<>();
		for(String key : inventory.keySet()) {
			//Filter make
			if(inventory.get(key).getMake().equalsIgnoreCase(keyword))
				resultList.add(inventory.get(key));
			//Filter model
			else if(inventory.get(key).getModel().equalsIgnoreCase(keyword))
				resultList.add(inventory.get(key));
			//Filter year
			else if(String.valueOf(inventory.get(key).getYear()).equalsIgnoreCase(keyword))
				resultList.add(inventory.get(key));
			//Filter condition
			else if(inventory.get(key).getCondition().toString().equalsIgnoreCase(keyword))
				resultList.add(inventory.get(key));
			//Filter VIN
			else if(inventory.get(key).getVIN().equalsIgnoreCase(keyword))
				resultList.add(inventory.get(key));
			//Filter price
			else if(String.valueOf(inventory.get(key).getPrice()).equalsIgnoreCase(keyword))
				resultList.add(inventory.get(key));
			//Filter mileage
			else if(String.valueOf(inventory.get(key).getMileage()).equalsIgnoreCase(keyword))
				resultList.add(inventory.get(key));
						
		}
		return resultList;
	}
}
