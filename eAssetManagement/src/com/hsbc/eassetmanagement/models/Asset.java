package com.hsbc.eassetmanagement.models;

import java.time.LocalDate;

public class Asset {
	private long uniqueId;
	private String assetName;
	private String assetType;
	private String description;
	private LocalDate dateAdded;
	private boolean isAvailable;
	private int lendingPeriod;  /////////to be discussed
	private double lateReturnFee; //perday
	private int noOfDaysBanned; //standard
	private LocalDate dueDate;  //duedate... can be null when asset is not lended by anyone
	
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public long getUniqueId() {
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
	public LocalDate getDateAdded() {
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
	public LocalDate getDueDate() {
		return dueDate;
	}
	public Asset(long uniqueId, String assetName, String assetType, String description, LocalDate dateAdded,
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
	
	
}
