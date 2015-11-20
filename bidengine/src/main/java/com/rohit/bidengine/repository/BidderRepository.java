package com.rohit.bidengine.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rohit.bidengine.application.GenericHasher;
import com.rohit.bidengine.model.BidItem;
import com.rohit.bidengine.model.Bidder;
import com.rohit.bidengine.model.User;

public class BidderRepository {

	//Create the global variables here
	HashMap<String, User> bidUserData = BidUserStub.getInstance();
	HashMap<String,BidItem> bidItemData = BidItemStub.getInstance();
	
	public BidderRepository() {
	}
	
	//This function createBidder will create a user bidder
	public User createBidder(User user) {
		User userObj = new User();
		userObj.setUserName(user.getUserName());
		bidUserData.put(userObj.getUserName(), userObj);
		return userObj;
	}
	
	public BidItem createABidItem(BidItem bidItem) {
		BidItem bi = new BidItem();

		bi.setItemOwner(bidItem.getItemOwner());
		bi.setItemName(bidItem.getItemName());
		System.out.println("Item Name2: " + bi.getItemName());
		bi.setBidStartTime(new Date());
		bi.setItemID(GenericHasher.generateIDForItem(bi.getItemOwner().getBidderName(), bidItem.getItemName()));
		bi.setItemPrice(bidItem.getItemPrice());
		
		return bi;
	}
	
	public BidItem updateBidItem(BidItem bidItem) {
		BidItem bi = findBidItemByID(bidItem.getItemID());
		if (bi == null) {
			return createABidItem(bidItem);
		}
		else {
			
			//Update the item
			bi.setBidderName(bidItem.getBidderName());
			if(bidItem.getLastBidPrice() > bidItem.getItemPrice()) {
				bidItem.setLastBidPrice(bidItem.getLastBidPrice());
			}
		}
		
		return bi;
	}
	
	public List<Bidder> viewBiddersOnItemByPrice(String itemID) {
		List<Bidder> bidder = new ArrayList<Bidder>();
		
		
		
		
		return bidder;
	}
	
	public BidItem findBidItemByID(String bidItemID) {
		if(bidItemID == null) {
			return null;
		} else {
			return bidItemData.get(bidItemID);
		}
	}
	
	
	
	
}
