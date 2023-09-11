package com.hsbc.eassetmanagement.dao;

import com.hsbc.eassetmanagement.models.Asset;

public class BorrowerDaoImpl implements BorrowerDao {

	@Override
	public boolean singleUserRegistration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Asset borrowAsset(String assetType) {
		//go through asset table
		
		//search if user has any active asset
		
		// check if any asset is borrowed
		////if borrowed check if overdue
		///////if overdue calculate late fee and last date of being banned
	
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

}
