package com.codefury.easset.dao;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private Set<Integer> usedIds = new HashSet<>();
    private Random random = new Random();

    @Override
    public boolean generateUserId() {
        int maxAttempts = 1000; // Max number of attempts to generate a unique user ID
        int maxUserId = 99999999; // Max user ID(8 digits)

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            int userId = random.nextInt(maxUserId) + 10000000; //Generate a random 8 digit user ID
            if (!usedIds.contains(userId)) {
                usedIds.add(userId);
                System.out.println("Generated User ID: " + userId);
                return true;
            }
        }
        
        System.out.println("Failed to generate a unique User ID after " + maxAttempts + " attempts.");
        return false;
    }
}

