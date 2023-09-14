package com.codefury.eassetmanagement.views;

import java.util.Scanner;
import com.codefury.eassetmanagement.bl.BorrowerBL;
import com.codefury.eassetmanagement.bl.BorrowerBLImpl;
import com.codefury.eassetmanagement.models.Asset;
import com.codefury.eassetmanagement.models.Borrower;

public class BorrowerApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BorrowerBL borrowerBL = new BorrowerBLImpl();
		
		System.out.println("Enter Choice: (1-Login / 2-Register)\n");
		int choice = sc.nextInt();
		
		if(choice==1) {
			login(sc, borrowerBL);
		}
		else if(choice==2) {
			System.out.println("Register User: "+borrowerBL.singleUserRegistration("Sanjana", "1234567892", "a@b.com", "bcjhbd,"));
		}
		else {
			System.out.println("Invalid user type");
		}
		
		sc.close();
	}

	private static void login(Scanner sc, BorrowerBL borrowerBL) {
		//login
		System.out.println("Enter user name: ");
		String userName = sc.next();
		
		System.out.println("Enter password: ");
		String password = sc.next();
		
		if(borrowerBL.validUser(userName, password)) {
			//Borrow asset
			Borrower borrower = new Borrower("Ana", "1234567892", "a@b.com", "44373730", "bcjhbd,");
			System.out.println("Borrower: "+borrower);
			
			Asset asset = borrowerBL.borrowAsset(borrower, "Laptop");
			if(asset==null)
				System.out.println("No asset found for given type");
			else
				System.out.println("Borrowed Asset: "+asset);
		}
		else {
			System.out.println("Invalid user");
		}
	}

}
