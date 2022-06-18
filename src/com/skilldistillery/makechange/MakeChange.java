package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		//add scanner
		Scanner scanner = new Scanner(System.in);
        // sysout
		System.out.println("what is the price of the item? ");
		double priceOfItem = scanner.nextDouble();
        // sysout
		System.out.println("How much money was tendered by the customer? ");
		double tenderedByCustomer = scanner.nextDouble();
        
		boolean notEnoughChange = false;
		
		boolean exactChange = false;
	    
		
		
		notEnoughChange = priceOfItem > tenderedByCustomer;
	    exactChange = priceOfItem == tenderedByCustomer;

		if (notEnoughChange == true) {
			System.out.println("Customer provided inefficient funds ");
		}
		else if (exactChange == true) {
			System.out.println("Thank You for the exact amount!");
		}
		
		
		double change = tenderedByCustomer - priceOfItem;
		
		System.out.println(change);
		
		
		
		
		
		
		
		
		
		
		
		
		scanner.close();	
	}

}
