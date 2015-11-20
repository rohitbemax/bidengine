package com.rohit.bidengine.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BidItem {
	
	private String itemName;
	private String itemID;
	private double itemPrice;
	private Date bidStartTime;
	private double lastBidPrice;
	
	private String bidderName;
	private Bidder itemOwner;
	private Date timeToCloseBid;
	private Double priceToCloseBid;
	private int criteriaToCloseBid;
	
	public Bidder getItemOwner() {
		return itemOwner;
	}

	public void setItemOwner(Bidder itemOwner) {
		this.itemOwner = itemOwner;
	}

	public Date getTimeToCloseBid() {
		return timeToCloseBid;
	}

	public void setTimeToCloseBid(Date timeToCloseBid) {
		this.timeToCloseBid = timeToCloseBid;
	}

	public Date getBidStartTime() {
		return bidStartTime;
	}

	public void setBidStartTime(Date bidStartTime) {
		this.bidStartTime = bidStartTime;
	}

	public double getLastBidPrice() {
		return lastBidPrice;
	}

	public void setLastBidPrice(double lastBidPrice) {
		this.lastBidPrice = lastBidPrice;
	}

	/*
	public BidItem(String itemID) {
		this.itemID = itemID;
	}
	*/
	
	/*
	public BidItem(String itemName, String itemID, double itemPrice) {
		this.itemName = itemName;
		this.itemID = itemID;
		this.itemPrice = itemPrice;
	}*/

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

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
}
