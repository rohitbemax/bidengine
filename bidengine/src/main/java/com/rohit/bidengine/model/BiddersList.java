package com.rohit.bidengine.model;

import java.util.List;

public class BiddersList {
	List<Bidder> biddersList;
	
	public BiddersList(List<Bidder> biddersList) {
		this.biddersList = biddersList;
	}

	public List<Bidder> getBiddersList() {
		return biddersList;
	}

	public void setBiddersList(List<Bidder> biddersList) {
		this.biddersList = biddersList;
	}
}
