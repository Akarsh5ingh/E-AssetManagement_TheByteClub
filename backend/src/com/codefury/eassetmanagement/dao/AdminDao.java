package com.codefury.eassetmanagement.dao;

import java.sql.Date;
import java.time.LocalDate;

public interface AdminDao {
	boolean deleteAsset();
//	String generateReport();		//to be discussed
	boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned);
}
