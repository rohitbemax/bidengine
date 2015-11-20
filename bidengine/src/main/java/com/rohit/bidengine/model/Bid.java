package com.rohit.bidengine.model;

import java.util.Date;

public class Bid {
	
	private Date bidStartTime;
	private BidItem bidItem;
	private BiddersList biddersList;
	
	public Date getBidStartTime() {
		return bidStartTime;
	}

	public void setBidStartTime(Date bidStartTime) {
		this.bidStartTime = bidStartTime;
	}

	public BidItem getBidItem() {
		return bidItem;
	}

	public void setBidItem(BidItem bidItem) {
		this.bidItem = bidItem;
	}

	public BiddersList getBiddersList() {
		return biddersList;
	}

	public void setBiddersList(BiddersList biddersList) {
		this.biddersList = biddersList;
	}
}
