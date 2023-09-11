package com.hsbc.eassetmanagement.bl;

import java.time.LocalDate;

public interface AdminBL {
	boolean addNewAsset(String assetName, String assetType, String description, LocalDate dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned, LocalDate dueDate);
	boolean deleteAsset();
//	String generateReport();		//to be discussed
}
