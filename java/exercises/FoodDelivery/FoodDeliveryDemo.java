package com.skillstorm.assignments.week6.FoodDelivery;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.skillstorm.assignments.week6.FoodDelivery.beans.*;

public class FoodDeliveryDemo {
	
	private static Restaurant restaurant;
	private static Set<Order> orderSet;
	private static Item springrolls, pho, banhmi, 
						grilledpork, crepewrap, stickyrice, 
						housesalad, pancake, noodlesoup,
						icedtea, milkcoffee;
	private static Random random = new Random();
	
	public static void main(String[] args) {
		//1.initialize restaurant and build a menu
		restaurant = new Restaurant("VIETNAMESE RESTAURANT");
		buildMenu();
	
		//2.create some customers to start making their orders
		Customer chuong = new Customer("Chuong", "(832)788-1234");
		Customer john 	= new Customer("John", "(832)788-6789");
		Customer mike 	= new Customer("Mike", "(832)788-3456");
		
		//3.customers are making theirs orders and the time 
		//to complete will be random from 15 minutes to 90 minutes.
		
		Order order1 = new Order(chuong);	//1st customer	
		order1.addItem(banhmi, 2);
		order1.addItem(pho, 1);
		order1.addItem(icedtea, 1);
		order1.addItem(banhmi, 2);			//increase 2 units of this item
		order1.editItemAmount(icedtea, 2);	//edit new amount units of this item
		order1.setCompleteTime(LocalDateTime.now().plusMinutes(15 + random.nextInt(76)));
		System.out.println("Taking " + order1.getCustomer().getName() + "'s order.\n");
		
		delay(5000);
		
		Order order2 = new Order(john);		//2nd customer
		order2.addItem(housesalad, 2);
		order2.addItem(grilledpork, 2);
		order2.addItem(pancake, 3);
		order2.addItem(milkcoffee, 2);
		order2.setCompleteTime(LocalDateTime.now().plusMinutes(15 + random.nextInt(76)));
		System.out.println("Taking " + order2.getCustomer().getName() + "'s order.\n");
		
		delay(3000);
		
		Order order3 = new Order(mike);		//3rd customer	
		order3.addItem(springrolls, 4);
		order3.addItem(stickyrice, 2);
		order3.addItem(pho, 1);
		order3.addItem(icedtea, 2);
		order3.setCompleteTime(LocalDateTime.now().plusMinutes(15 + random.nextInt(76)));
		System.out.println("Taking " + order3.getCustomer().getName() + "'s order.\n");
		
		delay(2000);
		
		//4. The program stores all of orders in hashset, so they are not in any order
		collectOrder(order2);
		collectOrder(order1);
		collectOrder(order3);
		

		//5. The restaurant starts collecting the orders from the hashset 
		//and put in its priority queue. The order of an order in the queue
		//will be determined based upon the time the order was placed.
		Iterator<Order> iterator = orderSet.iterator();	
		while(iterator.hasNext()) {
			restaurant.addOrder(iterator.next());
		}
		
		//6. The restaurant processes the orders from the priority queue.
		//and print the receipt after delivery.
		
		int counter = 0;
		while(counter < restaurant.getTotalOrders()) {
			
			Order readyOrder = restaurant.makeDelivery();
			System.out.println("Processing order " + readyOrder.getOrderID() + "\n");
			restaurant.printReceipt(readyOrder);
			System.out.println("-------------------------------------------");
			delay(1000);
		}
	
		System.out.println("\n\n");
		System.out.println(restaurant);
		
		System.exit(0);
	}
	
	/*
	 * The method builds the complete restaurant's menu
	 */
	public static void buildMenu() {
		springrolls = new Item(MenuItem.SPRING_ROLLS, 4.50);
		pho         = new Item(MenuItem.PHO,          9.25);
		banhmi      = new Item(MenuItem.BANHMI,       5.00);
		grilledpork = new Item(MenuItem.GRILLED_PORK, 6.00);
		crepewrap   = new Item(MenuItem.CREPE_WRAP,   7.50);
		stickyrice  = new Item(MenuItem.STICKY_RICE,  3.75);
		housesalad  = new Item(MenuItem.HOUSE_SALAD,  3.00);
		pancake     = new Item(MenuItem.PANCAKE,      3.00);
		noodlesoup  = new Item(MenuItem.NOODLE_SOUP,  6.75);
		icedtea     = new Item(MenuItem.ICED_TEA,     2.25);
		milkcoffee  = new Item(MenuItem.MILK_COFFEE,  4.25);
	}
	
	/*
	 * The method collects every single order and 
	 * store in the hashset data structure
	 */
	public static void collectOrder(Order order) {		
		if(order == null)
			throw new NullPointerException("Error: Order cannot be null");
		
		if(orderSet == null) 
			orderSet = new HashSet<>();
		
		orderSet.add(order);
	}
		
	/*
	 * The order allows to delay n milliseconds
	 */
	public static void delay(int milliseconds) {	
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}

}
