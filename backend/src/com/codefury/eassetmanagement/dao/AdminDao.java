package com.codefury.eassetmanagement.dao;

import java.sql.Date;
import java.time.LocalDate;

import com.codefury.eassetmanagement.models.Asset;

public interface AdminDao {
	boolean deleteAsset();
//	String generateReport();		//to be discussed
	boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned);
	boolean addNewAsset(Asset asset);
	String generateUserId();
	boolean addNewAsset(String userId, String assetName, String assetType, String description, java.util.Date dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned);
}
