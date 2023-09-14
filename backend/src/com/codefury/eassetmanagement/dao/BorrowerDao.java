package com.codefury.eassetmanagement.dao;

import com.codefury.eassetmanagement.models.Asset;
import com.codefury.eassetmanagement.models.Borrower;

public interface BorrowerDao {
	boolean importUsers(String filePath);
	double viewDueAmount();
	boolean singleUserRegistration(String name, String telephone, String email, String password);
	Asset borrowAsset(Borrower borrower, String assetType);
	boolean isUserBanned(String userId);
	boolean validUser(String userName, String password);
}
