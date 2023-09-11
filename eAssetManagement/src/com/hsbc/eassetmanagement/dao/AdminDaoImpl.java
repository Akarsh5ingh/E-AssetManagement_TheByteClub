package com.hsbc.eassetmanagement.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.hsbc.eassetmanagement.exceptions.UserIDNotgeneratedException;

public class AdminDaoImpl implements AdminDao {

	private Set<String> hashedUserIds = new HashSet<>();
    private Random random = new Random();

    private long generateUserId() {
        int maxAttempts = 1000; // Max number of attempts to generate a unique user ID
        int maxUserId = 99999999; // Max user ID(8 digits)

        long userId = -1;
        
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            userId = random.nextInt(maxUserId) + 10000000; //Generate a random 8 digit user ID 
            if (!hashedUserIds.contains(userId)) {
            	String userIdString =Long.toString(userId);
            	hashedId(userIdString);
            	hashedUserIds.add(userIdString);
                
                System.out.println("Generated User ID: " + userId);
                return userId;
            }
        }
        
        System.out.println("Failed to generate a unique User ID after " + maxAttempts + " attempts.");
        return userId;
    }
    
	@Override
	public boolean addNewAsset(String assetName, String assetType, 
			String description, LocalDate dateAdded, 
			boolean isAvailable, int lendingPeriod, 
			double lateReturnFee, 
			int noOfDaysBanned, 
			LocalDate dueDate) {
		// TODO Auto-generated method stub
		long userId=generateUserId();
		if(userId==-1)
		{
			//Custom exception 
			//if userid is not generated
			throw new UserIDNotgeneratedException("User Id is no generated");
		}
		
		
		
		return false;
	}

	@Override
	public boolean deleteAsset() {
		// TODO Auto-generated method stub
		return false;
	}
	public String hashedId(String userId) {
		String hashedId = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");//using message digest to get the functionality for hashing data and specifying the SHA-256 algorithm
		
			byte[] hashByte = md.digest(userId.getBytes(StandardCharsets.UTF_8));//we use md to hash the password. We convert the password string into bytes using UTF-8 encoding
			//the md.digest is called to compute the hash of these bytes, the result is a array of bytes that stores the password
			
			//convert the byte array to a hexadecimal representation
			StringBuilder hexHash = new StringBuilder();
			for(byte b: hashByte) { //iterating through the byte array
				hexHash.append(String.format("%20x", b));//formatting each byte as a two-character hexadecimal string using string.format
			}
			hashedId = hexHash.toString();
			return hashedId;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
