package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rohit.bidengine.model.BidItem;
import com.rohit.bidengine.model.Bidder;

public class TestClient {

	@Test
	public void testCreate() {
		BidderClient client = new BidderClient();
		
		Bidder bidder = new Bidder();
		bidder.setBidderName("Rohit");		
		bidder = client.create(bidder);
		
		assertNotNull(bidder);
	}
	
	@Test
	public void testBidItemCreate() {
		BidderClient client = new BidderClient();
		BidItem item = new BidItem();
		
		Bidder bidder = new Bidder();
		bidder.setBidderName("Rohit");
		
		item.setItemOwner(bidder);
		item.setItemName("iphone 6s");
		item.setItemPrice(200000.0);
		
		item = client.createItem(item);
		
		assertNotNull(item);
	}
}