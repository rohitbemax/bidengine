package com.rohit.bidengine.repository;

import java.util.List;

import com.rohit.bidengine.model.BidItem;

public interface IBidItem {

	void addItem(BidItem bidItem);

	boolean checkIfItemExists(String itemID);

	void createBidder(String itemID);
	
	public List<BidItem> getBidItemList();

}