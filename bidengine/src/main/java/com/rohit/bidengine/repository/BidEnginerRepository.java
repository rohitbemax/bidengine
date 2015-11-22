package com.rohit.bidengine.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

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
		
		//Check if the user is registered then only create the bid item else return NULL object
		if(!bidUserData.containsKey(bidItem.getItemOwnerUser())) {
			System.out.println("No Item owner found");
			return null;
		}
		
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
		
		//Put the bid in the bidder tree set
		Bidder bidder = new Bidder();
		bidder.setBidderName(bi.getItemOwnerUser());
		bidder.setBidPrice(bidItem.getItemPrice());
		bid.getTopBidderSet().getBidderTS().add(bidder);
		
		//Add to the global hash
		bidItemData.put(bid.getBidItem().getItemID(), bid);
		
		return bi;
	}
	
	
	public List<Bidder> viewBiddersOnItemByPrice(String bidItemID) {
		List<Bidder> bidderList = new ArrayList<Bidder>();
		
		Bid bid = findBidByItemID(bidItemID);
		TreeSet<Bidder> bidderTS = bid.getTopBidderSet().getBidderTS();
		
		int i = 0;
		for(Bidder b : bidderTS) {
			if(i++ >= 5) {
				break;
			}
			
			Bidder bidder = new Bidder();
			bidder.setBidderName(b.getBidderName());
			bidder.setBidPrice(b.getBidPrice());
			
			//Add the bidder to the bidderList which will contain the list of top 5 bidders
			bidderList.add(bidder);
		}
		
		return bidderList;
	}
	
	public BidItem updateBidItemWithBid(BidItem bidItem, String bidItemID) {
		Bid bid = findBidByItemID(bidItemID);
		
		//Case 1: Check if the bid time has crossed the time-margin set for bidding
		if(bid.getBidFianlTimeToElapse() < new Date().getTime()) {
			System.out.println("Bid over coz of time constraint");
			bid.setBidOver(true);
		}
				
		//Case 2: Check if the new bid price crosses the final price set by bidder
		if(bidItem.getBidFinalPrice() > bid.getBidFinalPrice()) {
			System.out.println("Bid over coz of time price");
			bid.setBidOver(true);
		}
		
		if(bid.isBidOver() == true) {
			return bid.getBidItem();
		}
		
		//If bid is not over udpate the bid item
		//Once you create a bid item create a bid also
		BidItem item = new BidItem();
		item = bid.getBidItem();
		item.setItemPrice(bidItem.getItemPrice());
		bid.setBidItem(item);
		bid.setBidOver(false);
		bid.setLastBidder(bidItem.getItemOwnerUser());
		bid.setLastBidPrice(bidItem.getItemPrice());
				
		//Add to the global hash
		bidItemData.remove(bidItemID);
		bidItemData.put(bidItemID, bid);
		
		
		return bid.getBidItem();
	}
	
	//Find the Bid object from the bid global map
	public Bid findBidByItemID(String bidItemID) {
		return bidItemData.get(bidItemID);
	}
	
	//This function is user to get the BidItem from the Bid repository
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
	
	//This function will return will the BidItems from the repository
	public List<BidItem> getAllBidItems() {
		List<BidItem> bidItemList = new ArrayList<>();
	    
	    Iterator<Map.Entry<String, Bid>> iterator = bidItemData.entrySet().iterator() ;
        while(iterator.hasNext()){
            Map.Entry<String, Bid> bid = iterator.next();
            bidItemList.add(bid.getValue().getBidItem());
        }
	    
	    return bidItemList;
	}
}
