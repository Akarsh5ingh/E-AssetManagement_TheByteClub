package com.codefury.eassetmanagement.bl;

import java.util.Date;

public interface AdminBL {
	boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned, Date dueDate);
	boolean deleteAsset();
//	String generateReport();		//to be discussed
}
