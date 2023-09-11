package com.hsbc.eassetmanagement.dao;

import com.hsbc.eassetmanagement.models.Asset;

public interface BorrowerDao {
	boolean singleUserRegistration();
	boolean importUsers(String filePath);
	Asset borrowAsset(String assetType);
	double viewDueAmount();
}
