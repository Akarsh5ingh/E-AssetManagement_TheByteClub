package com.codefury.eassetmanagement.views;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter User Type: (1-Admin / 2-Borrower)\n");
		int choice = sc.nextInt();
		
		if(choice==1) {
			AdminApp.main(args);
		}
		else if(choice==2) {
			BorrowerApp.main(args);
		}
		else {
			System.out.println("Invalid user type");
		}
		
		sc.close();
	}
}
