package com.hsbc.eassetmanagement.bl;

import com.hsbc.eassetmanagement.models.Asset;

public interface BorrowerBL {
	boolean singleUserRegistration();
	boolean importUsers(String filePath);
	Asset borrowAsset(String assetType);
	double viewDueAmount();
}
