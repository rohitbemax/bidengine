package com.rohit.bidengine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.rohit.bidengine.application.BidderComparator;

public class BidderTreeSet {
	
	TreeSet<Bidder> bidderTS;
	
	public BidderTreeSet() {
		bidderTS = new TreeSet<Bidder>(new BidderComparator());
	}
	
	public TreeSet<Bidder> getBidderTS() {
		return bidderTS;
	}
	
	public static List<Bidder> getTopFiveBiddersForItem(List<Bidder> bidderList) {
		TreeSet<Bidder> bidderTressSet = new TreeSet<Bidder>(new BidderComparator());
		List<Bidder> tmpBidderList = new ArrayList<Bidder>(); 
		
		for(Bidder b : bidderList) {
			bidderTressSet.add(b);
		}
	
		int i = 0;
	
		for(Bidder b : bidderTressSet){
			System.out.println(b.getBidderName());
            System.out.println(b.getBidPrice());
            
            if(i > 5) {
            	break;
            }
            
            Bidder tmpBdr = new Bidder();
            tmpBdr.setBidderName(b.getBidderName());
            tmpBdr.setBidPrice(b.getBidPrice());
            tmpBidderList.add(tmpBdr);
        }
		
		return tmpBidderList;
	}
}
