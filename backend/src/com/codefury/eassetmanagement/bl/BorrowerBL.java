package com.codefury.eassetmanagement.bl;

import com.codefury.eassetmanagement.models.Asset;
import com.codefury.eassetmanagement.models.Borrower;

public interface BorrowerBL {
	boolean singleUserRegistration(String name, String telephone, String email, String password);
	boolean importUsers(String filePath);
	Asset borrowAsset(Borrower borrower, String assetType);
	double viewDueAmount();
	boolean validUser(String userName, String password);
}
