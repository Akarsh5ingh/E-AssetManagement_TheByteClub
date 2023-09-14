package com.codefury.eassetmanagement.dao;

<<<<<<< HEAD
=======
import java.sql.ResultSet;

import com.codefury.eassetmanagement.exceptions.UserBannedException;
>>>>>>> 4013569d1039b865dfe0749ae739382380694cfc
import com.codefury.eassetmanagement.models.Asset;
import com.codefury.eassetmanagement.models.Borrower;

public interface BorrowerDao {
	boolean importUsers(String filePath);
	double viewDueAmount();
	boolean singleUserRegistration(String name, String telephone, String email, String password) throws UserBannedException;
	Asset borrowAsset(Borrower borrower, String assetType);
	boolean isUserBanned(String userId);
	boolean validUser(String userName, String password);
}
