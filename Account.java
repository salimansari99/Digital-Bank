package DigitalBank;
import java.util.*;
public class Account {

	
	//class variables
	int balance;
	int prevTransaction;
	String CustomerName;
	String CustomerId;
	
	public Account(String CustomerName, String CustomerId) {
		this.CustomerName = CustomerName;
		this.CustomerId = CustomerId;
	}
	
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			prevTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			prevTransaction = -amount;
		}
	}
	void getPrevTransaction() {
		if(prevTransaction > 0) {
			System.out.println("Deposited : " + prevTransaction);
		}
		else if(prevTransaction < 0) {
			System.out.println("Withdrawn : " + Math.abs(prevTransaction));
		}
		else System.out.println("No Tarnsaction Occured");
	}
	
	void calculateInterest(int years) {
		double interest = .0185;
		double newBalance = (balance*interest*years) + balance;
		System.out.println("The current Interest rate is : " + (interest*100));
		System.out.println("After "+years + " years, your balance will be : "+newBalance);
	}
	
	void showMenu() {
		char option = '\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("Hey " +CustomerName +" ! your account has been Created");
		System.out.println("Your CustomerId is : " + CustomerId);
		System.out.println();
		System.out.println("What would you like to do ?");
		System.out.println();
		System.out.println("Enter A to check Balance");
		System.out.println("Enter B to make a deposit");
		System.out.println("Enter C to withdraw money");
		System.out.println("Enter D to view previousTransaction");
		System.out.println("Enter E to calculate interest");
		System.out.println("Enter F to exit");
		
		do {
			System.out.println();
			System.out.println("Enter a option");
			char option1 = sc.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			switch(option) {
			case 'A' :
				System.out.println("==========================");
				System.out.println("Balance : $ " + balance);
				System.out.println("==========================");
				System.out.println();
				break;
				
			case 'B' :
				System.out.println("Enter amount to deposit : ");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println();
				break;
			
			case 'C' :
				System.out.println("Enter amount to withdraw : ");
				int amount1 = sc.nextInt();
				withdraw(amount1);
				System.out.println();
				break;
				
			case 'D' :
				System.out.println("==========================");
				getPrevTransaction();
				System.out.println("==========================");
				System.out.println();
				break;
				
			case 'E' :
				System.out.println("Enter time period to know interest ");
				int year = sc.nextInt();
				calculateInterest(year);
				System.out.println();
				break;
				
			case 'F' :
				System.out.println("==========================");
				break;
				
			default :
				System.out.println("Error : Invalid option ");
				break;
			}
		} while(option != 'F');
		
		 System.out.println("Thank you for banking with us !");	
	}
}
