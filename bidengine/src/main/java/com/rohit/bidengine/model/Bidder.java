package com.rohit.bidengine.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bidder {
	
	private String bidderName;
	private Double bidPrice;
	
	public Double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
}