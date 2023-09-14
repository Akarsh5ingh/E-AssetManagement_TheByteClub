package com.hsbc.eassetmanagement.bl;

import com.hsbc.eassetmanagement.dao.BorrowerDao;
import com.hsbc.eassetmanagement.models.Asset;

public class BorrowerBLImpl implements BorrowerBL {
private BorrowerDao borrowerDAO; // Assuming you have a BorrowerDAO

    public void Borrower(BorrowerDao borrowerDao) {
        this.borrowerDAO = borrowerDAO;
    }

    public boolean singleUserRegistration() {
        // implement user registration 
        // Return true if registration is successful, otherwise false
        return false; 
    }

    public boolean importUsers(String filePath) {
        //  implement user import logic 
       
        return false; 
    }

    public Asset borrowAsset(String assetType) {
        // You can implement asset borrowing logic here
        // Example: Search for an available asset of the specified type and borrow it
        Asset assetToBorrow = borrowerDAO.borrowAsset(assetType);

        if (assetToBorrow != null) {
            // Check if the borrower already has an active asset
            if (hasActiveAsset()) {
                // Check if the active asset is overdue
                if (isAssetOverdue()) {
                    // Calculate late fee and update last date of being banned
                    double lateFee = calculateLateFee();
                    updateLastDateOfBan();
                    return null; // Asset cannot be borrowed due to overdue status
                }
            }

            // Borrow the asset and update its status using the BorrowerDAO
            borrowerDAO.updateAssetStatus(assetToBorrow.getUniqueId(), true);

            // You can return the borrowed asset here
            return assetToBorrow;
        }

        return null; // No available assets of the specified type found
    }

    public double viewDueAmount() {
        // You can implement logic to view the due amount here
        // Return the due amount
        return 0.0; 
    }

    private boolean hasActiveAsset() {
        // You can implement logic to check if the borrower has an active asset
        // Return true if there is an active asset, otherwise false
        return false; // Placeholder, you should implement actual logic to check for active assets
    }

    private boolean isAssetOverdue() {
        // You can implement logic to check if the active asset is overdue
        // Return true if overdue, otherwise false
        return false; 
    }

    private double calculateLateFee() {
        // You can implement logic to calculate the late fee for the overdue asset
        // Return the calculated late fee
        return 0.0; 
    }

    private void updateLastDateOfBan() {
        // You can implement logic to update the last date of being banned for the borrower
        // This can be useful when a borrower has an overdue asset
        // Update the last date of being banned in the database using the BorrowerDAO
    }
}
