package com.codefury.eassetmanagement.bl;

import com.codefury.eassetmanagement.models.Asset;

public interface BorrowerBL {
	boolean singleUserRegistration();
	boolean importUsers(String filePath);
	Asset borrowAsset(String assetType);
	double viewDueAmount();
}
