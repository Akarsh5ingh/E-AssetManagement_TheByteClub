package com.codefury.eassetmanagement.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import com.codefury.eassetmanagement.helper.MySQLHelper;
import com.codefury.eassetmanagement.models.Asset;
import com.codefury.eassetmanagement.models.Borrower;

public class BorrowerDaoImpl implements BorrowerDao {
	Connection conn;
	ResourceBundle resourceBundle;
	PreparedStatement statement;
	ResultSet resultSet;
	private Set<String> hashedUserIds = new HashSet<>();
	private Set<Long> usedIds = new HashSet<>();
	private Random random = new Random();


	public BorrowerDaoImpl() {
		super();
		this.resourceBundle = ResourceBundle.getBundle("com/codefury/eassetmanagement/resources/db");
	}


	@Override
	public boolean singleUserRegistration(String name, String telephone, 
			String email, String password) {
		String borrowerId = generateUserId();
		// create statement
		try {
			conn = MySQLHelper.getConnection();
			String query = this.resourceBundle.getString("createUser");
			int rows=0;
			this.statement = conn.prepareStatement(query);
			this.statement.setString(1, borrowerId);
			this.statement.setString(2, name);
			this.statement.setString(3, "Borrower");
			this.statement.setString(4, telephone);
			this.statement.setString(5, email);
			this.statement.setString(6, password);
			this.statement.setBoolean(7, false);
			System.out.println(this.statement);
				
			rows=this.statement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			//create custom exception
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Asset borrowAsset(Borrower borrower, String assetType) {
		// go through asset table
		// search if user has any active asset that is overdue
		System.out.println(isUserBanned(borrower.getUserId()));
		if(isUserBanned(borrower.getUserId()))
			return null;
		// check if any asset is borrowed
		//// if borrowed check if overdue
		/////// if overdue calculate late fee and last date of being banned
		//else--> //get list of available assets
		//allocate one asset-->add userid in asset row
		
		ResultSet result = getAssetList(assetType);
		
		if(result!=null) {
			Asset asset=getFirstAsset(result, borrower.getUserId());
			return asset;
		}
	
		return null;
	}

	@Override
	public double viewDueAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean importUsers(String filePath) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isUserBanned(String userId) {
		// create statement
		ResultSet result = null;
		try {
			conn = MySQLHelper.getConnection();
			String query = this.resourceBundle.getString("getBorrowerAssets");
			this.statement = conn.prepareStatement(query);
			this.statement.setString(1, userId);
//			System.out.println(this.statement);
			result = this.statement.executeQuery();
//			System.out.println(result);
			
			if(anyAssetOverDue(result)) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// create custom exception
			System.out.println(e);
		}
		return false;
	}
	
	private Asset getFirstAsset(ResultSet assetList, String borrowerid) {
		Asset asset=new Asset();
		try {
			while(assetList.next()) {
				asset.setUniqueId(assetList.getString("UniqueId"));
				asset.setAssetName(assetList.getString("AssetName"));
				asset.setAssetType(assetList.getString("AssetType"));
				asset.setDescription(assetList.getString("Description"));
				asset.setDateAdded(assetList.getDate("DateAdded"));
				asset.setAvailable(true);
				asset.setLendingPeriod(assetList.getInt("LendingPeriod"));
				asset.setLateReturnFee(assetList.getDouble("LateReturnFee"));
				asset.setNoOfDaysBanned(assetList.getInt("NoOfDaysBanned"));
				//set borrower id
				asset.setBorrowerId(borrowerid);
				//set borrowedDate to current date
				asset.setBorrowedDate(new Date());
				//calculate dueDate
				asset.setDueDate(getDueDate(asset.getBorrowedDate(), asset.getLendingPeriod()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asset;
	}
	
	
	private ResultSet getAssetList(String AssetType) {
		ResultSet result = null;
		try {
			conn = MySQLHelper.getConnection();
			String query = this.resourceBundle.getString("getAvailableAssets");
			this.statement = conn.prepareStatement(query);
			this.statement.setString(1, AssetType);
//			System.out.println(this.statement);
			result = this.statement.executeQuery();			
			
		} catch (ClassNotFoundException | SQLException e) {
			// create custom exception
			System.out.println(e);
		}
		return result;
	}
	
	private boolean anyAssetOverDue(ResultSet assetList) {
		//loop over all assets
		try {
			while(assetList.next()) {
				//check if any asset overdue
				Date borrowedDate = assetList.getDate("BorrowedDate");
				int lendingPeriod = assetList.getInt("LendingPeriod");
				Date dueDate = assetList.getDate("DueDate");
				if(isOverDue(new Date(), dueDate))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	private boolean isOverDue(Date date1, Date date2) {
        // Compare two Date objects
        if (date1.compareTo(date2)<=0)
        	return false;
        else
        	return true;	
        	
    }
	
	
	private Date getDueDate(Date dateAssigned, int lendingPeriod) {
		Date dueDate=null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateAssigned);

        // Add the specified number of days
        calendar.add(Calendar.DAY_OF_MONTH, lendingPeriod);

        // Get the new date
        dueDate =  (Date) calendar.getTime();

        return dueDate;	
	}
	
	private String generateUserId() {
		int maxAttempts = 1000; // Max number of attempts to generate a unique user ID
		int maxUserId = 99999999; // Max user ID(8 digits)

		long userId = -1;
		String finalUserId=null;
		for (int attempt = 0; attempt < maxAttempts; attempt++) {
			userId = random.nextInt(maxUserId) + 10000000; // Generate a random 8 digit user ID
			if (!usedIds.contains(userId)) {
				usedIds.add(userId);
				System.out.println("Generated User ID: " + userId);
				finalUserId=String.valueOf(userId);
			}
		}

		System.out.println("Failed to generate a unique User ID after " + maxAttempts + " attempts.");
		return finalUserId;
	
	}

	private String hashedId(String userId) {
		String hashedId = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");// using message digest to get the functionality for
																	// hashing data and specifying the SHA-256 algorithm

			byte[] hashByte = md.digest(userId.getBytes(StandardCharsets.UTF_8));// we use md to hash the password. We
																					// convert the password string into
																					// bytes using UTF-8 encoding
			// the md.digest is called to compute the hash of these bytes, the result is a
			// array of bytes that stores the password

			// convert the byte array to a hexadecimal representation
			StringBuilder hexHash = new StringBuilder();
			for (byte b : hashByte) { // iterating through the byte array
				hexHash.append(String.format("%20x", b));// formatting each byte as a two-character hexadecimal string
															// using string.format
			}
			hashedId = hexHash.toString();
			return hashedId;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
