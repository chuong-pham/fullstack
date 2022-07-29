package com.skillstorm.assignments.week5.car_lot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.skillstorm.assignments.week5.car_lot.beans.*;
//import com.skillstorm.assignments.week5.car_lot.interfaces.*;

/*
 * The program simulates a car lot operation
 */
public class Program {
	
	//CLASS PROPERTIES
	private static CarLot mainLot = new CarLot("Main Lot");
	
	
	//SYSTEM-GENERATED METHOD
	public static void main(String[] args) {
		//1. Create some cars to test the program
		Random random = new Random();
		Car chuongCar = new Car("Toyota", "Camry", 2006, CarCondition.PreOwned, 5000);
		Car mikeCar = new Car("Ford", "Mustang", 2020, CarCondition.Certified, 46000);
		Car jessicaCar = new Car("Tesla", "S", 2022, CarCondition.New, 105000);
		Car tomCar = new Car("Honda", "Civic", 2010, CarCondition.Certified, 15000);
		Car henryCar = new Car("Toyota", "Camry", 2010, CarCondition.PreOwned, 8000);
		List<Car> cars = new ArrayList<>(Arrays.asList(chuongCar, mikeCar, jessicaCar, tomCar, henryCar));
		Car jerryCar = null; //Invalid car
		Car johnCar = new Car("Ford", "F-150", 2022, CarCondition.New, 35000);	//the car not in main lot
		
		
		//2. add cars to the main car lot and return the total number of cars
		for(int i = 0; i < cars.size(); i++) {
			importCar(cars.get(i));
		}
		System.out.println("Total: " + mainLot.getTotalCars() + " vehicles.");
		System.out.println("-----------------------------------------------------");
		
		//3. search for any car by keyword (Make, Year, Model, Condition, mileage, price)
		String keyword = "toyota";
		System.out.println("Filtering: " + keyword + "...");
		searchCar(keyword);	
		System.out.println("-----------------------------------------------------");
		
		//4. Sell a random car from the main lot
		Car randomCar = cars.get(random.nextInt(cars.size()));
		sellCar(randomCar);
		System.out.println("-----------------------------------------------------");
		
		//5. Attempt to add a duplicate car to the main lot will result a warning
		importCar(chuongCar);
		System.out.println("-----------------------------------------------------");
		
		//6. Sell a car that is not in the main lot will throw an exception
		sellCar(johnCar);
		System.out.println("-----------------------------------------------------");
		
		//7. Sell a null car will also throw an exception
		sellCar(jerryCar);
		System.out.println("-----------------------------------------------------");
		
		//8. Sort the car list by price
		ComparePrice comparePrice = new ComparePrice();
		Collections.sort(cars, comparePrice);		
		System.out.println("The sorted list...");
		displaySortedList(cars);
		
		
	}
	
	
	//CUSTOM METHODS
	public static void importCar(Car car) {
		try {
			mainLot.addCar(car);
			System.out.println("Added " + car + " to the " + mainLot.getName());
		}
		catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Car sellCar(Car car) {
		Car soldCar = null;
		try {
			if(car == null)
				throw new NullPointerException("Error: The car cannot be null.");
			
			soldCar = mainLot.removeCar(car.getVIN());
			System.out.println("Sold " + car);
		}
		
		catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		return soldCar;
	}
	
	public static void searchCar(String keyword) {
		List<Car> result = mainLot.filter(keyword);
		System.out.println("Result: " + result.size() + " matching vehicles found.");
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static <T> void displaySortedList(List<T> list) {	
		for(T item : list) {
			System.out.println(item);
		}
	}

}
