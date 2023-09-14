package com.codefury.eassetmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import com.codefury.eassetmanagement.exceptions.UserIDNotgeneratedException;
import com.codefury.eassetmanagement.helper.MySQLHelper;
import com.codefury.eassetmanagement.models.Administrator;

public class AdminDaoImpl implements AdminDao {

	private Set<Long> usedIds = new HashSet<>();
	private Random random = new Random();

	private Set<String> hashedUserIds = new HashSet<>();
//    private Random random = new Random();

	Connection conn;
	ResourceBundle resourceBundle;
	PreparedStatement statement;
	ResultSet resultSet;
	private String role;
	
	public AdminDaoImpl() {
		super();
		this.resourceBundle = ResourceBundle.getBundle("com/codefury/eassetmanagement/resources/db");
		this.role="Administrator";
	}
	
	@Override
	public Administrator createAdmin(String name, String telephone, String email, String password) {
		String adminId = "ADMINID";
		
		Administrator admin=null;
		// create statement
		try {
			conn = MySQLHelper.getConnection();
			String query = this.resourceBundle.getString("createUser");
			int rows=0;
			this.statement = conn.prepareStatement(query);
			this.statement.setString(1, adminId);
			this.statement.setString(2, name);
			this.statement.setString(3, this.role);
			this.statement.setString(4, telephone);
			this.statement.setString(5, email);
			this.statement.setString(6, password);
			this.statement.setBoolean(7, false);
			System.out.println(this.statement);
				
			rows=this.statement.executeUpdate();
			
			if(rows>0) {
				admin = new Administrator();
				admin.setUserId(adminId);	
				admin.setName(name);
				admin.setEmail(email);
				admin.setTelephone(telephone);
				admin.setPassword(password);
				return admin;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			//create custom exception
			System.out.println(e);
		}
		
		return admin;
	}

	@Override
	public boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded, int lendingPeriod, double lateReturnFee, int noOfDaysBanned) {
		Date dueDate=null; //initially null
		Date borrowedDate=null;
		String borrowerId=null;
		String userId = generateUserId();
		if (userId == null) {
			// Custom exception
			// if userid is not generated
			throw new UserIDNotgeneratedException("User Id is no generated");
		}

		// create statement
		try {
			conn = MySQLHelper.getConnection();
			String query = this.resourceBundle.getString("addAsset");
			int rows=0;
			this.statement = conn.prepareStatement(query);
			this.statement.setString(1, userId);
			this.statement.setString(3, assetName);
			this.statement.setString(2, assetType);   //so that all case wont effect asset type
 			this.statement.setString(4, description);
			this.statement.setDate(5, dateAdded);
			this.statement.setBoolean(6, true);  //by default
			this.statement.setInt(7, lendingPeriod);
			this.statement.setDouble(8, lateReturnFee);
			this.statement.setInt(9, noOfDaysBanned);
			this.statement.setString(10, borrowerId);
			this.statement.setDate(11, borrowedDate);
			this.statement.setDate(12, dueDate);
			System.out.println(this.statement);
				
			rows=this.statement.executeUpdate();
			if(rows>0)
				return true;
		} catch (ClassNotFoundException | SQLException e) {
			//create custom exception
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean deleteAsset() {
		// TODO Auto-generated method stub
		return false;
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
				return finalUserId;
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

	@Override
	public boolean validUser(String userName, String password) {
		ResultSet rows=null;
		try {
			conn = MySQLHelper.getConnection();
			String query = this.resourceBundle.getString("getUser");
			
			this.statement = conn.prepareStatement(query);
			this.statement.setString(1, userName);
			this.statement.setString(2, password);
			this.statement.setString(3, this.role);  
			System.out.println(this.statement);
				
			rows=this.statement.executeQuery();
			if(rows!=null)
				return true;
		} catch (ClassNotFoundException | SQLException e) {
			//create custom exception
			System.out.println(e);
		}
		return false;
	}

}
