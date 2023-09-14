package com.codefury.eassetmanagement.models;

import java.util.Date;
import java.time.LocalDate;

public class Asset {
	private String uniqueId;
	private String assetName;
	private String assetType;
	private String description;
	private Date dateAdded;
	private boolean isAvailable;
	private int lendingPeriod;  /////////to be discussed
	private double lateReturnFee; //perday
	private int noOfDaysBanned; //standard
	private String borrowerId;
	private Date borrowedDate;
	private Date dueDate;  //duedate... can be null when asset is not lended by anyone
	
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public String getAssetName() {
		return assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public String getDescription() {
		return description;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public int getLendingPeriod() {
		return lendingPeriod;
	}
	public double getLateReturnFee() {
		return lateReturnFee;
	}
	public int getNoOfDaysBanned() {
		return noOfDaysBanned;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public Asset(String uniqueId, String assetName, String assetType, String description, Date dateAdded,
			boolean isAvailable, int lendingPeriod, double lateReturnFee, int noOfDaysBanned) {
		super();
		this.uniqueId = uniqueId;
		this.assetName = assetName;
		this.assetType = assetType;
		this.description = description;
		this.dateAdded = dateAdded;
		this.isAvailable = isAvailable;
		this.lendingPeriod = lendingPeriod;
		this.lateReturnFee = lateReturnFee;
		this.noOfDaysBanned = noOfDaysBanned;
	}
	
	public Asset() {
		// TODO Auto-generated constructor stub
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public void setLendingPeriod(int lendingPeriod) {
		this.lendingPeriod = lendingPeriod;
	}
	public void setLateReturnFee(double lateReturnFee) {
		this.lateReturnFee = lateReturnFee;
	}
	public void setNoOfDaysBanned(int noOfDaysBanned) {
		this.noOfDaysBanned = noOfDaysBanned;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(String borrowerId) {
		this.borrowerId = borrowerId;
	}
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date date) {
		this.borrowedDate = date;
	}
	@Override
	public String toString() {
		return "Asset [uniqueId=" + uniqueId + ", assetName=" + assetName + ", assetType=" + assetType
				+ ", description=" + description + ", dateAdded=" + dateAdded + ", isAvailable=" + isAvailable
				+ ", lendingPeriod=" + lendingPeriod + ", lateReturnFee=" + lateReturnFee + ", noOfDaysBanned="
				+ noOfDaysBanned + ", borrowerId=" + borrowerId + ", borrowedDate=" + borrowedDate + ", dueDate="
				+ dueDate + "]";
	}
	
	
}
