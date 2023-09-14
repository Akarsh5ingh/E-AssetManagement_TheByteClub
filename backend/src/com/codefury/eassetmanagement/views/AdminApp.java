package com.codefury.eassetmanagement.views;

import java.sql.Date;
import java.util.Scanner;

import com.codefury.eassetmanagement.bl.AdminBL;
import com.codefury.eassetmanagement.bl.AdminBLImpl;

public class AdminApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminBL adminBl = new AdminBLImpl();
		
		//login
		System.out.println("Enter user name: ");
		String userName = sc.next();
		
		System.out.println("Enter password: ");
		String password = sc.next();
		
		if(adminBl.validUser(userName, password)) {
			//Create new asset
			System.out.println("Add asset: "+adminBl.addNewAsset("Laptop", "IT", "hbmh", Date.valueOf("1900-11-11"), 10, 50, 20));
		}
		else {
			System.out.println("Invalid user");
		}
		
		sc.close();
	}
	
}
