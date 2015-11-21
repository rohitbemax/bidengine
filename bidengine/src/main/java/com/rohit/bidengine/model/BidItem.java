package com.rohit.bidengine.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BidItem {
	
	private String itemName;
	private String itemID;
	private double itemPrice;
	private Date bidStartTime;
	private String itemOwnerUser;
	private int hoursToBid;
	private double bidFinalPrice;
	private int bidCriteria;
	
	public double getBidFinalPrice() {
		return bidFinalPrice;
	}

	public void setBidFinalPrice(double bidFinalPrice) {
		this.bidFinalPrice = bidFinalPrice;
	}

	public int getBidCriteria() {
		return bidCriteria;
	}

	public int getHoursToBid() {
		return hoursToBid;
	}

	public void setHoursToBid(int hoursToBid) {
		this.hoursToBid = hoursToBid;
	}

	public void setBidCriteria(int bidCriteria) {
		this.bidCriteria = bidCriteria;
	}

	public String getItemOwnerUser() {
		return itemOwnerUser;
	}
	
	public void setItemOwnerUser(String itemOwnerUser) {
		this.itemOwnerUser = itemOwnerUser;
	}
	
	public Date getBidStartTime() {
		return bidStartTime;
	}

	public void setBidStartTime(Date bidStartTime) {
		this.bidStartTime = bidStartTime;
	}

		public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
}