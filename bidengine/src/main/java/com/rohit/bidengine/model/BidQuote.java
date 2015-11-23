package com.rohit.bidengine.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BidQuote {

	public String bidderName;
	public double bidPrice;
	
	public String getBidderName() {
		return bidderName;
	}
	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	
	
}
