package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		userPrompt();

		System.out.println("Thank you for using Make Change Calculator. ");
		scanner.close();
	}

	public static void userPrompt() {

		System.out.println("What is the price of the item? ");
		double priceOfItem = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("How much was tendered by the customer");
		double tenderedByCustomer = scanner.nextDouble();
		scanner.nextLine();

		boolean notEnoughFunds = priceOfItem > tenderedByCustomer;
		boolean exactChange = priceOfItem == tenderedByCustomer;

		if (notEnoughFunds) {
			System.out.println("Customer provided inefficient funds.\n ");
			userPrompt();
		} else if (exactChange) {
			System.out.println("Thank you for the exact change!.\n ");
			restart();
		} else {
			changeToGive(priceOfItem, tenderedByCustomer);

		}
	}

	public static void restart() {
		System.out.println("Would you like to enter another transaction?");
		String input = scanner.next();

		switch (input) {
		case "Y":
		case "y":
		case "Yes":
		case "yes":
			userPrompt();
			// break not required but for rep.
			break;
		case "N":
		case "n":
		case "No":
		case "no":
			return;
		// break;

		}
	}

	public static void changeToGive(double priceOfItem, double tenderedByCustomer) {

		double change = tenderedByCustomer - priceOfItem;

		// Define for the computer the different number currencies
		double twentyDollarBills = 20.00;
		double tenDollarBills = 10.00;
		double fiveDollarBills = 5.00;
		double oneDollarBills = 1.00;
		double twentyFiveCents = 0.25;
		double tenCents = 0.10;
		double fiveCents = 0.05;
		double Cent = 0.01;

		// Counting how many times we have to give the change.
		int countingTwenties = 0;
		int countingTens = 0;
		int countingFives = 0;
		int countingOnes = 0;
		int countingQuarters = 0;
		int countingDimes = 0;
		int countingNickels = 0;
		int countingPennies = 0;

		// Create a Variable to add Currencies to equal the change variable.
		double addChange = 0;

		// add currencies to addChange variable until it equals change variable
		while (addChange != change) {
			if (addChange + twentyDollarBills <= change) {
				addChange = addChange + twentyDollarBills;
				countingTwenties++;
			} else if (addChange + tenDollarBills <= change) {
				addChange = addChange + tenDollarBills;
				countingTens++;

			} else if (addChange + fiveDollarBills <= change) {
				addChange = addChange + fiveDollarBills;
				countingFives++;

			} else if (addChange + oneDollarBills <= change) {
				addChange = addChange + oneDollarBills;
				countingOnes++;

			} else if (addChange + twentyFiveCents <= change) {
				addChange = addChange + twentyFiveCents;
				countingQuarters++;

			} else if (addChange + tenCents <= change) {
				addChange = addChange + tenCents;
				tenCents++;

			} else if (addChange + fiveCents <= change) {
				addChange = addChange + fiveCents;
				countingNickels++;

			} else if (addChange + Cent <= change) {
				addChange += Cent;
				countingPennies++;
			}
			
		}
			currencies(countingTwenties, countingTens, countingFives, countingOnes, countingQuarters, countingDimes, countingNickels, countingPennies);


	}

	public static void currencies(int twenties, int tens, int fives, int ones, int quarters, int dimes, int nickles,
			int cent) {
		// create a variable for each parameter from left to right.
		int twentyDB = twenties;
		int tensDB = tens;
		int fivesDB = fives;
		int oneDB = ones;
		int quartersC = quarters;
		int dimesC = dimes;
		int nickelsC = nickles;
		int centC = cent;
		// make string variable with each currencie
		String twentyD = "twenty dollar bill";
		String tenDB = "ten dollar bill";
		String fiveDB = "five dollar bill";
		String onesDB = "one dollar bill";
		String quarterC = "quarter";
		String dimeC = "dime";
		String nickelC = "nickel";
		String pennies = "pennies";
		// make string variable to populate with variables with value is greater than 0
		String result = "";
		// look at each variable to see if its greater than 0 if it is it needs to go
		// into the string
		if (twentyDB > 0) {
           result += twentyDB + " " + twentyD + ",";
		}
		if (tensDB > 0) {
           result += tensDB + " " + tenDB + ",";
		}
        if (fivesDB > 0) {
        	  result += fivesDB + " " + fiveDB + ",";
        }
        if (oneDB > 0) {
        	  result += oneDB + " " + onesDB + ",";
        }
        if (quartersC > 0) {
        	  result += quartersC + " " + quarterC + ",";
        }
        if (dimesC > 0) {
        	  result += dimesC + " " + dimeC + ",";
        }
        if (nickelsC > 0) {
        	  result += nickelsC + " " + nickelC + ",";
        }
        if (centC > 0) {
        	  result += centC + " " + pennies + ",";
        }
        //we are creating a new version of the string that does not include the last character.
        String resultCopy = result.substring(0, result.length() - 1);
        resultCopy = resultCopy + ".";
        		
        System.out.println(resultCopy);
        
        restart();
        
	} 

}
