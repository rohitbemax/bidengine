package com.rohit.bidengine.application;

import java.util.Comparator;

import com.rohit.bidengine.model.Bidder;

public class BidderComparator implements Comparator<Bidder> {
	
	@Override
	public int compare(Bidder b1, Bidder b2) {
		if(b1.getBidPrice() > b2.getBidPrice()) {
			return -1;
		} else if(b1.getBidPrice() == b2.getBidPrice()) {
			return 0;
		} else {
			return 1;
		}
	}
}
