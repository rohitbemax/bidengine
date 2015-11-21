package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rohit.bidengine.model.BidItem;
import com.rohit.bidengine.model.Bidder;
import com.rohit.bidengine.model.User;

public class TestClient {

	@Test
	public void testCreate() {
		BidderClient client = new BidderClient();
		
		User user = new User();
		user.setUserName("Rohit");		
		user = client.create(user);
		
		assertNotNull(user);
	}
	
	@Test
	public void testBidItemCreate() {
		BidderClient client = new BidderClient();
		BidItem bidItem = new BidItem();
		
		Bidder bidder = new Bidder();
		bidder.setBidderName("Rohit");
		

		bidItem.setItemName("iphone 6s");
		bidItem.setItemPrice(200000.0);
		
		bidItem = client.createItem(bidItem);
		
		assertNotNull(bidItem);
	}
	
	@Test
	public void testBidCreation() {
		BidderClient client = new BidderClient();
		BidItem bidItem = new BidItem();
		
		Bidder bidder = new Bidder();
		bidder.setBidderName("Rohit");
		

		bidItem.setItemName("iphone 6s");
		bidItem.setItemPrice(200000.0);
		
		bidItem = client.createItem(bidItem);
		
		assertNotNull(bidItem);
	}
	
	@Test
	public void testBidUpdation() {
		BidderClient client = new BidderClient();
		BidItem bidItem = new BidItem();
		
		Bidder bidder = new Bidder();
		bidder.setBidderName("Rohit");
		

		bidItem.setItemName("iphone 6s");
		bidItem.setItemPrice(200000.0);
		
		bidItem = client.createItem(bidItem);
		
		assertNotNull(bidItem);
	}

}