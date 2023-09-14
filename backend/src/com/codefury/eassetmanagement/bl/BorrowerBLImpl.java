package com.codefury.eassetmanagement.bl;

import com.codefury.eassetmanagement.dao.BorrowerDao;
import com.codefury.eassetmanagement.dao.BorrowerDaoImpl;
import com.codefury.eassetmanagement.exceptions.UserBannedException;
import com.codefury.eassetmanagement.models.Asset;
import com.codefury.eassetmanagement.models.Borrower;

import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.SimpleDateFormat;

public class BorrowerBLImpl implements BorrowerBL {
    private BorrowerDao borrowerDao;
    private ResourceBundle resourceBundle;
    private Set<String> hashedUserIds;
    private Set<Long> usedIds;
    private Random random;
    private SimpleDateFormat dateFormat;

    public BorrowerBLImpl() {
        borrowerDao = new BorrowerDaoImpl();
        resourceBundle = ResourceBundle.getBundle("com/codefury/eassetmanagement/resources/db");
        hashedUserIds = new HashSet<>();
        usedIds = new HashSet<>();
        random = new Random();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Date format for parsing dates
    }

    public boolean singleUserRegistration(String name, String telephone, String email, String password) {
        try {
            // Validate input data
            if (!isValidName(name) || !isValidTelephone(telephone) || !isValidEmail(email) || !isValidPassword(password)) {
                return false;
            }

            // Call the DAO method for registration
            return borrowerDao.singleUserRegistration(name, telephone, email, password);
        } catch (UserBannedException e) {
            // Handle the UserBannedException here
            e.printStackTrace(); // You can log the exception details
            return false;
        }
    }

    public boolean importUsers(String filePath) {
        try {
            // Validate the filePath 
            // logic 

            return borrowerDao.importUsers(filePath);
        } catch (Exception e) {
            // Handle any exceptions thrown during import
            e.printStackTrace(); // You can log the exception details
            return false;
        }
    }

    public Asset borrowAsset(Borrower borrower, String assetType) throws UserBannedException {
        // Validate input data
		if (!isValidAssetType(assetType)) {
		    return null;
		}

		// Call the DAO method to borrow an asset
		return borrowerDao.borrowAsset(borrower, assetType);
    }

    public double viewDueAmount() {
        
        return 0.0;
    }

    // Validation methods
    private boolean isValidName(String name) {
        // Name should not be empty and should only contain letters and spaces
        return !name.isEmpty() && name.matches("^[a-zA-Z ]+$");
    }

    private boolean isValidTelephone(String telephone) {
        // Telephone should be a 10-digit number
        return Pattern.matches("^\\d{10}$", telephone);
    }

    private boolean isValidEmail(String email) {
        // Simple email validation: Check if it contains @ and .
        return email.contains("@") && email.contains(".");
    }

    private boolean isValidPassword(String password) {
        // Password should be at least 8 characters long and contain a combination of letters, digits, and special characters
        return password.length() >= 8 && password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$");
    }

    private boolean isValidAssetType(String assetType) {
        // Asset type should not be empty
        return !assetType.isEmpty();
    }


@Override
public boolean singleUserRegistration() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Asset borrowAsset(String assetType) {
	// TODO Auto-generated method stub
	return null;
}
}






