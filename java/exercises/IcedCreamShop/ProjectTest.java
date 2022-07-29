package com.skillstorm.assignments.week4.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import com.skillstorm.assignments.week4.beans.Customer;
import com.skillstorm.assignments.week4.beans.IceCream;
import com.skillstorm.assignments.week4.beans.IceCreamShop;

/*
 * The program simulates an ice-cream store that is selling
 * new flavors to customers. The customers must get in line and 
 * wait to be served as First In First Out (FIFO)
 */

public class ProjectTest {
	
	public static void main(String[] args) {	
		//1. Create a brand new ice cream shop with three available ice cream flavors
		IceCream chocolate = new IceCream("Chocolate", 6.00);
		IceCream vanilla = new IceCream("Vanilla", 5.00);
		IceCream strawberry = new IceCream("Strawberry", 15.00);
		IceCream blueberry = new IceCream("Blueberry", 8.00);
		IceCream neapolitan = new IceCream("Neapolitan", 12.00);	
		ArrayList<IceCream> flavors = new ArrayList<>(Arrays.asList(chocolate, vanilla, strawberry));		
		IceCreamShop dairyQueen = new IceCreamShop("Dairy Queen", flavors);
		displayStoreSign(dairyQueen);
		
		//2. Create some customers with their ice cream flavors		
		Customer john = new Customer("John", null);			//John doesn't have a flavor
		Customer troy = new Customer("Troy", chocolate);	//Troy will buy a chocolate flavor
		Customer sean = new Customer("Sean", chocolate);	//Sean's chocolate will be out of order
		Customer fred = new Customer("Fred", strawberry);	//Fred will buy a strawberry flavor
		
		//3. Customers start queuing up in order
		getInLine(dairyQueen, john);	//1st: John
		getInLine(dairyQueen, troy);	//2nd: Troy
		getInLine(dairyQueen, sean);	//3rd: Sean
		getInLine(dairyQueen, fred);	//4th: Fred
		
		//4. Display the available ice-cream flavors and the first customer in line
		displayShopStatus(dairyQueen);
		
		//5. The shop is serving customer (FIFO)
		serveCustomer(dairyQueen);		//Serve John ==> error
		serveCustomer(dairyQueen);		//Serve Troy ==> success		
		serveCustomer(dairyQueen);		//Serve Sean ==> fail because out of flavor
		serveCustomer(dairyQueen);		//Serve Fred ==> success
		
		//6. Display the available ice-cream flavors and the first customer in line
		displayShopStatus(dairyQueen);	//Now it's only Vanilla available
		
		//7. Attempt to serve an empty customer line
		serveCustomer(dairyQueen);
		
		
		//8. John came back in line and decided to buy Vanilla
		john.setIceCream(vanilla);
		getInLine(dairyQueen, john);
		serveCustomer(dairyQueen);
		
		//9. Display current earning
		displayEarning(dairyQueen);	// Total of 3 flavors = $26.00
		
		//10. Display the available ice-cream flavors and the first customer in line
		displayShopStatus(dairyQueen);	//No more flavors or customer in line
		
		//11. The shop stocks 2 more new flavors
		stockAFlavor(dairyQueen, blueberry);
		stockAFlavor(dairyQueen, neapolitan);
		
		//12. A new customer gets in line and buy vanilla
		Customer mike = new Customer("Mike", vanilla);
		getInLine(dairyQueen, mike);
		serveCustomer(dairyQueen);
		
		displayEarning(dairyQueen);
	}
	
	public static void displayStoreSign(IceCreamShop shop) {
		System.out.println("**************************************");
		System.out.println("*"+shop.getName().toUpperCase() + " ICE CREAM IS NOW OPENING*");
		System.out.println("**************************************");
	}
	
	public static void displayShopStatus(IceCreamShop shop) {
		System.out.println("--------------------------------------------------");
		System.out.println(shop);
		System.out.println("--------------------------------------------------");
	}
	
	
	public static void stockAFlavor(IceCreamShop shop, IceCream flavor) {
		
		try {
			shop.addFlavor(flavor);
			System.out.println("The shop added " + flavor.getFlavor()  + " flavor into the freezer.");
		}
		
		catch (NullPointerException | IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			System.out.println();		
		}
	}
	
	public static void removeAFlavor(IceCreamShop shop, IceCream flavor) {
		
		try {
			shop.removeFlavor(flavor);
			System.out.println("Removed " + flavor.getFlavor() + " flavor from the freeze.");
		}
		catch (NullPointerException | IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			System.out.println();		
		}
	}
	
	public static void getInLine(IceCreamShop shop, Customer customer) {
		
		try {
			shop.addCustomer(customer);
			
			System.out.println(customer.getName() + " is getting in line.");
			
		}
		catch(NullPointerException exception) {
			System.out.println(exception.getMessage());
			System.out.println();
		}
	}
	
	public static void serveCustomer(IceCreamShop shop) {
		try {
			shop.serviceCustomer();
			System.out.println("This order is complete.");
		}
		catch(NoSuchElementException | IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			System.out.println();
		}
		
	}
	
	public static void displayEarning(IceCreamShop shop) {
		System.out.println("..................................................");
		System.out.println("Current earning: $"+ shop.getTotalEarnings());
		System.out.println("..................................................");
	}
}
