package com.codefury.eassetmanagement.dao;

import java.sql.Date;

import com.codefury.eassetmanagement.models.Administrator;

public interface AdminDao {
	boolean deleteAsset();
//	String generateReport();		//to be discussed
	boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded,
			 int lendingPeriod, double lateReturnFee, int noOfDaysBanned);
	Administrator createAdmin(String name, String telephone, String email, String password);
	boolean validUser(String userName, String password);
}
