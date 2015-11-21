package com.rohit.bidengine.model;

import java.util.Date;

public class Bid {
	
	private Date bidStartTime;
	private BidItem bidItem;
	private BiddersList biddersList;
	private boolean isBidOver;
	private double lastBidPrice;
	private String lastBidder;
	private double bidFinalPrice;
	private int bidFianlTimeToElapse;
	private long bidFinalTimeEpoch;

	public int getBidFianlTimeToElapse() {
		return bidFianlTimeToElapse;
	}

	public void setBidFianlTimeToElapse(int bidFianlTimeToElapse) {
		this.bidFianlTimeToElapse = bidFianlTimeToElapse;
	}

	public long getBidFinalTimeEpoch() {
		return bidFinalTimeEpoch;
	}

	public void setBidFinalTimeEpoch(long bidFinalTimeEpoch) {
		this.bidFinalTimeEpoch = bidFinalTimeEpoch;
	}

	public double getBidFinalPrice() {
		return bidFinalPrice;
	}

	public void setBidFinalPrice(double bidFinalPrice) {
		this.bidFinalPrice = bidFinalPrice;
	}

	private BidderTreeSet topBidderSet = new BidderTreeSet();
	
	public boolean isBidOver() {
		return isBidOver;
	}

	public String getLastBidder() {
		return lastBidder;
	}

	public void setLastBidder(String lastBidder) {
		this.lastBidder = lastBidder;
	}

	public void setBidOver(boolean isBidOver) {
		this.isBidOver = isBidOver;
	}

	public double getLastBidPrice() {
		return lastBidPrice;
	}

	public void setLastBidPrice(double lastBidPrice) {
		this.lastBidPrice = lastBidPrice;
	}

	public BidderTreeSet getTopBidderSet() {
		return topBidderSet;
	}

	public void setTopBidderSet(BidderTreeSet topBidderSet) {
		this.topBidderSet = topBidderSet;
	}

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
