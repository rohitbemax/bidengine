package com.rohit.bidengine.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BidStatus {

	private double lastHighestBidPrice;
	private double currentUsersBid;
	private boolean isBidClosed;
	private boolean isBidPlacedSuccessfully;
	
	public double getCurrentUsersBid() {
		return currentUsersBid;
	}

	public void setCurrentUsersBid(double currentUsersBid) {
		this.currentUsersBid = currentUsersBid;
	}

	public boolean isBidClosed() {
		return isBidClosed;
	}

	public void setBidClosed(boolean isBidClosed) {
		this.isBidClosed = isBidClosed;
	}

	public boolean isBidPlacedSuccessfully() {
		return isBidPlacedSuccessfully;
	}

	public void setBidPlacedSuccessfully(boolean isBidPlacedSuccessfully) {
		this.isBidPlacedSuccessfully = isBidPlacedSuccessfully;
	}

	public double getLastHighestBidPrice() {
		return lastHighestBidPrice;
	}
	
	public void setLastHighestBidPrice(double lastHighestBidPrice) {
		this.lastHighestBidPrice = lastHighestBidPrice;
	}
}
