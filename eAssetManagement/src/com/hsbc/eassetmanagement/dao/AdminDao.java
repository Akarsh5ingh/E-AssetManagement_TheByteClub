package com.hsbc.eassetmanagement.dao;

import java.time.LocalDate;

public interface AdminDao {
	boolean deleteAsset();
//	String generateReport();		//to be discussed
	boolean addNewAsset(String assetName, String assetType, String description, LocalDate dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned, LocalDate dueDate);
}
