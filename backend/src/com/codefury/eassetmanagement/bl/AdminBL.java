package com.codefury.eassetmanagement.bl;

import java.sql.Date;

import com.codefury.eassetmanagement.models.Administrator;

public interface AdminBL {
	Administrator createAdmin(String name, String telephone, String email, String password);
	boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded,
			int lendingPeriod, double lateReturnFee, int noOfDaysBanned);
	boolean deleteAsset();
	boolean validUser(String userName, String password);
//	String generateReport();		//to be discussed
}
