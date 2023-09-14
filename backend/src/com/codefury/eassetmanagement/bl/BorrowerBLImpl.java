package com.codefury.eassetmanagement.bl;

import com.codefury.eassetmanagement.dao.BorrowerDao;
import com.codefury.eassetmanagement.dao.BorrowerDaoImpl;
import com.codefury.eassetmanagement.models.Asset;
import com.codefury.eassetmanagement.models.Borrower;

public class BorrowerBLImpl implements BorrowerBL {
	BorrowerDao borrowerDao;

	public BorrowerBLImpl() {
		super();
		this.borrowerDao=new BorrowerDaoImpl();
	}

	

	@Override
	public boolean importUsers(String filePath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double viewDueAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean singleUserRegistration(String name, String telephone, String email, String password) {
		return this.borrowerDao.singleUserRegistration(name, telephone, email, password);
	}



	@Override
	public Asset borrowAsset(Borrower borrower, String assetType) {
		return this.borrowerDao.borrowAsset(borrower, assetType);
	}



	@Override
	public boolean validUser(String userName, String password) {
		return this.borrowerDao.validUser(userName, password);
	}

}
