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
			System.out.println("Customer provided insufficient funds.\n ");
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
		double twentyFiveCents = 25;
		double tenCents = 10;
		double fiveCents = 05;
		double Cent = 01;

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
		// double change = 0;

		// add currencies to change variable until it equals change variable
		while (change >= 1) {
			if (change >= twentyDollarBills) {
				change = change - twentyDollarBills;
				countingTwenties++;
			} else if (change >= tenDollarBills) {
				change = change - tenDollarBills;
				countingTens++;

			} else if (change >= fiveDollarBills) {
				change = change - fiveDollarBills;
				countingFives++;

			} else if (change >= oneDollarBills) {
				change = change - oneDollarBills;
				countingOnes++;

			}
		}
		
		//System.out.println("this is the change value" + change);
		//System.out.println(amountRemaining);

		int amountRemaining = (int) ((change * 100)+ 0.5);
		
		while (amountRemaining != 0) {

			if (amountRemaining % twentyFiveCents == 0 || amountRemaining > twentyFiveCents) {
				amountRemaining -= twentyFiveCents;
				countingQuarters++;

			} else if (amountRemaining % tenCents == 0 || amountRemaining > tenCents) {
				amountRemaining -= tenCents;
				countingDimes++;

			} else if (amountRemaining % fiveCents == 0 || amountRemaining > fiveCents) {
				amountRemaining -= fiveCents;
				countingNickels++;

			} else if (amountRemaining % Cent == 0 || amountRemaining > Cent) {
				amountRemaining -= Cent;
				countingPennies++;
			}

		}
		//System.out.println(countingDimes);
		currencies(countingTwenties, countingTens, countingFives, countingOnes, countingQuarters, countingDimes,
				countingNickels, countingPennies);

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
		// we are creating a new version of the string that does not include the last
		// character.
		String resultCopy = result.substring(0, result.length() - 1);
		resultCopy = resultCopy + ".";

		System.out.println(resultCopy);

		restart();

	}

}
