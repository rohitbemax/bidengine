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
import com.rohit.bidengine.model.BidQuote;
import com.rohit.bidengine.model.BidStatus;
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
		bi.setBidFinalPrice(bidItem.getBidFinalPrice());
		bi.setItemID(GenericHasher.generateIDForItem(bidItem.getItemOwnerUser(), bidItem.getItemName()));
		
		//Once you create a bid item create a bid also
		Bid bid = new Bid();
		bid.setBidItem(bi);
		bid.setBidOver(false);
		bid.setBidStartTime(new Date());
		bid.setBidFinalPrice(bi.getBidFinalPrice());
		bid.setBidCriteria(bidItem.getBidCriteria());
		//We will get time and covert it to millsecs since epoch for future bid clojure comparison
		bid.setBidFinalTimeEpoch(bid.getBidStartTime().getTime() + (bidItem.getHoursToBid() * 60 * 60 * 1000));
		System.out.println("BidFinalTimeEpoch: " + bid.getBidFinalTimeEpoch());
		
		//Put the bid in the bidder tree set
		Bidder bidder = new Bidder();
		bidder.setBidderName(bi.getItemOwnerUser());
		bidder.setBidPrice(bidItem.getItemPrice());
		bid.getTopBidderSet().getBidderTS().add(bidder);
		
		//Add to the global hash
		System.out.println("Adding to global hash: " + bid.getBidItem().getItemID());
		bidItemData.put(bid.getBidItem().getItemID(), bid);
		
		return bi;
	}
	
	
	public List<Bidder> viewBiddersOnItemByPrice(String bidItemID) {
		List<Bidder> bidderList = new ArrayList<Bidder>();
		
		Bid bid = findBidByItemID(bidItemID);
		if(bid == null) {
			System.out.println("WARN: No such bid found in the record");
			return null;
		}
		TreeSet<Bidder> bidderTS = bid.getTopBidderSet().getBidderTS();
		
		System.out.println("Size: " + bidderTS.size());
		int i = 0;
		for(Bidder b : bidderTS) {
			if(i++ >= 5) {
				break;
			}
			
			Bidder bidder = new Bidder();
			bidder.setBidderName(b.getBidderName());
			bidder.setBidPrice(b.getBidPrice());
			
			System.out.println("Bidder Name: " + b.getBidderName());
			System.out.println("Bid Price: " + b.getBidPrice());
			
			//Add the bidder to the bidderList which will contain the list of top 5 bidders
			bidderList.add(bidder);
		}
		
		return bidderList;
	}
	
	public synchronized BidItem updateBidItemWithBid(BidQuote bidQuote, String bidItemID) {
		//Check to make sure that bid can only be placed by a registered user
		if(!bidUserData.containsKey(bidQuote.getBidderName())) {
			System.out.println("Bid user not registered!!");
			return null;
		}
		
		Bid bid = findBidByItemID(bidItemID);
		if(bid == null) {
			System.out.println("WARN: Null bid, will return from updateBidItemWithBidbb");
			return  null;
		}
		
		if(bid.isBidOver() == true) {
			System.out.println("Bid is over is true");
			return bid.getBidItem();
		}
		
		if(bid.getBidCriteria() == 1) 
		{	
			//Case 1: Check if the bid time has crossed the time-margin set for bidding
			if(bid.getBidFinalTimeEpoch() < new Date().getTime()) {
				System.out.println("Bid over coz of time constraint");
				bid.setBidOver(true);
			}
		}
		else 
		{	
			//Case 2: Check if the new bid price crosses the final price set by bidder
			if(bidQuote.getBidPrice() > bid.getBidFinalPrice()) 
			{
				System.out.println("Bid over coz of price");
				bid.setBidOver(true);
			}
		}
				
		//If bid is not over udpate the bid item once you create a bid item create a bid also
		
		BidItem item;
		item = bid.getBidItem();
		item.setItemPrice(bidQuote.getBidPrice());
		bid.setBidItem(item);
		
		Bidder bidder = new Bidder();
		bidder.setBidderName(bidQuote.getBidderName());
		bidder.setBidPrice(bidQuote.getBidPrice());
		
		bid.setLastBidder(bidQuote.getBidderName());
		bid.setLastBidPrice(bidQuote.getBidPrice());
		
		bid.getTopBidderSet().getBidderTS().add(bidder);
		
		System.out.println("Bid Item Price: " + bid.getLastBidPrice());
		System.out.println("Bid Item Owner: " + bid.getLastBidder());
		
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
