package com.rohit.bidengine.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.rohit.bidengine.application.GenericHasher;
import com.rohit.bidengine.model.BidItem;

public class BidItemStub implements IBidItem 
{
	private static HashMap<String, BidItem> bidItemsMap;
	
	public static HashMap<String, BidItem> getInstance() {
		if(bidItemsMap == null) {
			bidItemsMap = new HashMap<String, BidItem>();
			return bidItemsMap;
		} else {
			return bidItemsMap;
		}
	}
	
	public BidItemStub() {
		//bidItemsSet = new HashSet<String>();
	}
	
	/* (non-Javadoc)
	 * @see com.rohit.bidengine.repository.IBidItem#addItem(com.rohit.bidengine.model.BidItem)
	 */
	@Override
	public void addItem(BidItem bidItem) {
		bidItemsMap.put(bidItem.getItemID(), bidItem);
	}
	
	/* (non-Javadoc)
	 * @see com.rohit.bidengine.repository.IBidItem#checkIfItemExists(java.lang.String)
	 */
	@Override
	public boolean checkIfItemExists(String itemID) {
		return bidItemsMap.containsKey(itemID);
	}
	
	/* (non-Javadoc)
	 * @see com.rohit.bidengine.repository.IBidItem#createBidder(java.lang.String)
	 */
	@Override
	public void createBidder(String itemID) {
		if(checkIfItemExists(itemID)) {
			return;
		} else {
			//addItem(new BidItem(itemID));
		}
	}
	
	public List<BidItem> getBidItemList() {
		List<BidItem> bidItems = new ArrayList<BidItem>();
		
		
		for(int i=0; i <100000; i++) {
			BidItem bi = new BidItem();
			bi.setItemID(GenericHasher.generateIDForItem(i + "", "iPhone" + i));
			bi.setItemName("iName: " + i);
			bidItems.add(bi);
			System.out.println("Generating item: " + i);
		}
		
		return bidItems;
	}
	
}