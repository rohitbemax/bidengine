package com.rohit.bidengine.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.rohit.bidengine.application.GenericHasher;
import com.rohit.bidengine.model.Bid;
import com.rohit.bidengine.model.BidItem;
import com.rohit.bidengine.model.Bidder;
import com.rohit.bidengine.model.User;

public class BidEnginerRepository {

	//Create the global variables here
	HashMap<String, User> bidUserData = BidUserStub.getInstance();
	HashMap<String,Bid> bidItemData = BidItemStub.getInstance();
	
	public BidEnginerRepository() {
	}
	
	//This function createBidder will create a user bidder
	public User createUser(User user) {
		User userObj = new User();
		userObj.setUserName(user.getUserName());
		bidUserData.put(userObj.getUserName(), userObj);
		return userObj;
	}
	
	public BidItem createABidItem(BidItem bidItem) {
		BidItem bi = new BidItem();
		
		bi.setItemName(bidItem.getItemName());
		bi.setItemOwnerUser(bidItem.getItemOwnerUser());
		bi.setBidStartTime(new Date());
		bi.setItemPrice(bidItem.getItemPrice());
		bi.setBidCriteria(bidItem.getBidCriteria());
		bi.setItemID(GenericHasher.generateIDForItem(bidItem.getItemOwnerUser(), bidItem.getItemName()));
		
		//Once you create a bid item create a bid also
		Bid bid = new Bid();
		bid.setBidItem(bi);
		bid.setBidOver(false);
		bid.setBidStartTime(new Date());
		bid.setBidFinalPrice(bi.getBidFinalPrice());
		//We will get time and covert it to millsecs since epoch for future bid clojure comparison
		bid.setBidFinalTimeEpoch(bid.getBidStartTime().getTime() + (bid.getBidFianlTimeToElapse() * 60 * 1000));
		
		//Add to the global hash
		bidItemData.put(bid.getBidItem().getItemID(), bid);
		
		return bi;
	}
	
	/*
	public BidItem updateBidItem(BidItem bidItem) {
		BidItem bi = findBidItemByID(bidItem.getItemID());
		if (bi == null) {
			return createABidItem(bidItem);
		}
		else {
			
			//Update the item
			//bi.setBidderName(bidItem.getBidderName());
			//if(bidItem.getLastBidPrice() > bidItem.getItemPrice()) {
			//	bidItem.setLastBidPrice(bidItem.getLastBidPrice());
			//}
		}
		
		return bi;
	}
	*/
	
	public List<Bidder> viewBiddersOnItemByPrice(String itemID) {
		List<Bidder> bidder = new ArrayList<Bidder>();
		return bidder;
	}
	
	public BidItem updateBidItemWithBid(BidItem bidItem, String bidItemID) {
		Bid bid = findBidByItemID(bidItemID);
		
		//Case 1: Check if the bid time has crossed the time-margin set for bidding
		if(bid.getBidFianlTimeToElapse() < new Date().getTime()) {
			bid.setBidOver(true);
		}
				
		//Case 2: Check if the new bid price crosses the final price set by bidder
		if(bidItem.getBidFinalPrice() > bid.getBidFinalPrice()) {
			bid.setBidOver(true);
		}
		
		if(bid.isBidOver() == true) {
			return bid.getBidItem();
		}
		
		//If bid is not over udpate the bid item
		//Once you create a bid item create a bid also
		bid.setBidItem(bidItem);
		bid.setBidOver(false);
		bid.setLastBidder(bidItem.getItemOwnerUser());
		bid.setLastBidPrice(bidItem.getItemPrice());
				
		//Add to the global hash
		bidItemData.put(bid.getBidItem().getItemID(), bid);
		
		return bid.getBidItem();
	}
	
	public Bid findBidByItemID(String bidItemID) {
		return bidItemData.get(bidItemID);
	}
	
	public BidItem findBidItemByID(String bidItemID) {
		if(bidItemID == null) {
			return null;
		} else {
			 Bid bid = bidItemData.get(bidItemID);
			 if(bid != null) {
				 return bid.getBidItem();
			 } else {
				 return null;
			 }
		}
	}
	
	
	
	
}
