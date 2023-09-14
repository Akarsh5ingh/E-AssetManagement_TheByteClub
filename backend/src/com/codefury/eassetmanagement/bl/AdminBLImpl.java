package com.codefury.eassetmanagement.bl;


import java.util.Date;
import java.util.regex.Pattern;

import com.codefury.eassetmanagement.dao.AdminDao;
import com.codefury.eassetmanagement.exceptions.UserIDNotgeneratedException;
import com.codefury.eassetmanagement.helper.MySQLHelper;
import com.codefury.eassetmanagement.models.Asset;

public class AdminBLImpl implements AdminBL {
	
	
    private AdminDao adminDao;

    public AdminBLImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
    @Override
	public boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned, Date dueDate) {
        
    	try {
            // Generate a unique user ID for the asset
            String userId = adminDao.generateUserId();
            if (userId == null) {
                // Custom exception: UserIDNotgeneratedException
                throw new UserIDNotgeneratedException("User Id is not generated");
            }
         // Validate input data
            if (!isAssetNameValid(assetName) || !isAssetTypeValid(assetType) ||
          		  !isDescriptionValid(description) || !isDateAddedValid(dateAdded) ||
          		  !isLendingPeriodValid(lendingPeriod) || !isLateReturnFeeValid(lateReturnFee)
          		  || !isNoOfDaysBannedValid(noOfDaysBanned)){
          		   
          			  return false;// Validationfailed
          		  }
            // Call the DAO layer to add the new asset
            return adminDao.addNewAsset(userId, assetName, assetType, description, dateAdded,
                    isAvailable, lendingPeriod, lateReturnFee, noOfDaysBanned);
        } catch (UserIDNotgeneratedException e) {
            // Handle the custom exception (e.g., log the error)
            e.printStackTrace();
            return false;
        }
    	
    	
    	

    public boolean deleteAsset() {
        // Call the DAO layer to delete an asset
        boolean success = adminDao.deleteAsset();
        return success;
    }

    // Validation methods

    private boolean isAssetNameValid(String assetName) {
        return assetName != null && !assetName.trim().isEmpty() && assetName.length() <= 255;
    }

    private boolean isAssetTypeValid(String assetType) {
        String[] validTypes = {"Type1", "Type2", "Type3"}; // Replace with your valid types
        return assetType != null && !assetType.trim().isEmpty() && isValidAssetType(assetType);
    }

    private boolean isDescriptionValid(String description) {
        return description != null && !description.trim().isEmpty() && description.length() <= 1000;
    }

    private boolean isDateAddedValid(Date dateAdded) {
        if (dateAdded != null) {
            Date currentDate = new Date(System.currentTimeMillis());
            return !dateAdded.after(currentDate);
        }
        return false;
    }

    private boolean isLendingPeriodValid(int lendingPeriod) {
        return lendingPeriod > 0;
    }

    private boolean isLateReturnFeeValid(double lateReturnFee) {
        return lateReturnFee >= 0;
    }

    private boolean isNoOfDaysBannedValid(int noOfDaysBanned) {
        return noOfDaysBanned >= 0;
    }

    private boolean isValidAssetType(String assetType) {
        String[] validTypes = {"Type1", "Type2", "Type3"}; // Replace with your valid types
        return Pattern.compile(String.join("|", validTypes)).matcher(assetType).matches();
    }

    
}
