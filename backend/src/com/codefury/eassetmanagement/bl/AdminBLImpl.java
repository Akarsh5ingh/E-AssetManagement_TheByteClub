package com.codefury.eassetmanagement.bl;

import java.sql.Date;

import com.codefury.eassetmanagement.dao.AdminDao;
import com.codefury.eassetmanagement.dao.AdminDaoImpl;
import com.codefury.eassetmanagement.models.Administrator;

public class AdminBLImpl implements AdminBL {
	AdminDao adminDao;
			
	public AdminBLImpl() {
		this.adminDao = new AdminDaoImpl();
	}

	@Override
	public boolean deleteAsset() {
		return false;
	}


	@Override
	public Administrator createAdmin(String name, String telephone, String email, String password) {
		return this.adminDao.createAdmin(name, telephone, email, password);
	}

	@Override
	public boolean addNewAsset(String assetName, String assetType, String description, Date dateAdded,
			 int lendingPeriod, double lateReturnFee, int noOfDaysBanned) {
		return this.adminDao.addNewAsset(assetName, assetType, description, dateAdded, lendingPeriod, lateReturnFee, noOfDaysBanned);
	}

	@Override
	public boolean validUser(String userName, String password) {
		return this.adminDao.validUser(userName, password);
	}

}
