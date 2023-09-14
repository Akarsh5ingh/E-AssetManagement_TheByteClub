package com.codefury.eassetmanagement.views;

import java.sql.Date;

import com.codefury.eassetmanagement.bl.AdminBLImpl;
import com.codefury.eassetmanagement.dao.AdminDao;
import com.codefury.eassetmanagement.dao.AdminDaoImpl;
import com.codefury.eassetmanagement.dao.BorrowerDao;
import com.codefury.eassetmanagement.dao.BorrowerDaoImpl;

public class App {

	public static void main(String[] args) {
		AdminDao a = new AdminDaoImpl();
		a.addNewAsset("Laptop", "IT", "hbmh", Date.valueOf("1900-11-11"), false, 0, 0, 0);
		
		BorrowerDao b= new BorrowerDaoImpl();
//		b.isUserBanned("16612699");
		b.borrowAsset(null, null);
	}

}
