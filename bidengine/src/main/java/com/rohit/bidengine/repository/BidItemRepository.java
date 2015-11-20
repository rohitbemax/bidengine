package com.rohit.bidengine.repository;

import java.util.HashMap;

import javax.ws.rs.core.Response;

import com.rohit.bidengine.model.BidItem;

public class BidItemRepository {
	
	HashMap<String,BidItem> bidItemData = BidItemStub.getInstance();
	
	public BidItemRepository() {
	}
	
	public Response createUniqueBidder() {
		return Response.ok().build();
	}
	
	public Response createUniqueBidItem() {
		return Response.ok().build();
	}
	
	public Response placeBidOnItem() {
		
		return Response.ok().build();
	}
	
	public boolean checkIfBidItemAlreadExists() {
		return true;
	}
	
	public boolean checkIfBidOnItemExpired() {
		return true;
	}

}
