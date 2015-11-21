package com.rohit.bidengine.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BidStatus {

	private String statusMessage;
	private int bidReponseCode;
	private String lastHighestBidder;
	private double lastHighestBidPrice;
	
	public String getStatusMessage() {
		return statusMessage;
	}
	
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public int getBidReponseCode() {
		return bidReponseCode;
	}
	
	public void setBidReponseCode(int bidReponseCode) {
		this.bidReponseCode = bidReponseCode;
	}
	
	public String getLastHighestBidder() {
		return lastHighestBidder;
	}
	
	public void setLastHighestBidder(String lastHighestBidder) {
		this.lastHighestBidder = lastHighestBidder;
	}
	
	public double getLastHighestBidPrice() {
		return lastHighestBidPrice;
	}
	
	public void setLastHighestBidPrice(double lastHighestBidPrice) {
		this.lastHighestBidPrice = lastHighestBidPrice;
	}
}
