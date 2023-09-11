package com.hsbc.eassetmanagement.dao;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.hsbc.eassetmanagement.exceptions.UserIDNotgeneratedException;

public class AdminDaoImpl implements AdminDao {

	private Set<Long> usedIds = new HashSet<>();
    private Random random = new Random();

    private long generateUserId() {
        int maxAttempts = 1000; // Max number of attempts to generate a unique user ID
        int maxUserId = 99999999; // Max user ID(8 digits)

        long userId = -1;
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            userId = random.nextInt(maxUserId) + 10000000; //Generate a random 8 digit user ID
            if (!usedIds.contains(userId)) {
                usedIds.add(userId);
                System.out.println("Generated User ID: " + userId);
                return userId;
            }
        }
        
        System.out.println("Failed to generate a unique User ID after " + maxAttempts + " attempts.");
        return userId;
    }
    
	@Override
	public boolean addNewAsset() {
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

}
