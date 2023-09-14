package com.hsbc.eassetmanagement.bl;

import java.time.LocalDate;

import com.hsbc.eassetmanagement.dao.AdminDao;
import com.hsbc.eassetmanagement.models.Asset;

public class AdminBLImpl implements AdminBL {

	private AdminDao adminDao; // Assuming you have an AdminDAO

    public void Admin(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    

  

    private boolean validateAssetData(String assetName, String assetType, String description, LocalDate dateAdded, int lendingPeriod, double lateReturnFee, int noOfDaysBanned, LocalDate dueDate) {
        // Add your validation logic here
        // For example, check if required fields are not empty and if date fields are valid
        // Return true if data is valid, otherwise false
        return true; // Placeholder, you should implement actual validation
    }

    private boolean validateAssetId(String assetId) {
        // Add your validation logic here
        // For example, check if the asset with the given ID exists before deleting
        // Return true if the asset ID is valid, otherwise false
        return true; // Placeholder, you should implement actual validation
    }

	@Override
	public boolean addNewAsset(String assetName, String assetType, String description, LocalDate dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned, LocalDate dueDate) {
		// TODO Auto-generated method stub
		// You can perform validation and business logic here before adding the asset
        if (validateAssetData(assetName, assetType, description, dateAdded, lendingPeriod, lateReturnFee, noOfDaysBanned, dueDate)) {
            // Create an Asset object and add it using the AdminDAO
           // Asset asset = new Asset(assetName, assetType, description, dateAdded, isAvailable, lendingPeriod, lateReturnFee, noOfDaysBanned, dueDate);
            adminDao.addNewAsset(assetName, assetType, description, dateAdded, isAvailable, lendingPeriod, lateReturnFee, noOfDaysBanned, dueDate);
            return true;
        } else {
            return false; // Validation failed
        }
	}

	@Override
	public boolean deleteAsset(String assetId) {
		// TODO Auto-generated method stub
		 // You can perform validation and business logic here before deleting the asset
        if (validateAssetId(assetId)) {
            // Delete the asset using the AdminDAO
            adminDao.deleteAsset(assetId);
            return true;
        } else {
            return false; // Validation failed
        }
	}

}
