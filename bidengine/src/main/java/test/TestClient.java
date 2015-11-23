package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rohit.bidengine.model.BidItem;
import com.rohit.bidengine.model.BidQuote;
import com.rohit.bidengine.model.Bidder;
import com.rohit.bidengine.model.User;

public class TestClient {

	@Test
	public void testCreate() {
		BidderClient client = new BidderClient();
		
		User user = new User();
		user.setUserName("Rohit");		
		user = client.create(user);
		
		for(int i=0; i< 20; i++) {
			user = new User();
			user.setUserName("Ram Singh" + i);		
			user = client.create(user);
			assertNotNull(user);
		}
	}
	
	@Test
	public void testBidItemCreate() {
		BidderClient client = new BidderClient();
		

		for(int i=0; i<2; i++)	{
			BidItem bidItem = new BidItem();
			bidItem.setItemOwnerUser("Rohit");
			bidItem.setItemName("iphone" + i + "s" );
			bidItem.setItemPrice(200000.0 + i);
			bidItem.setBidFinalPrice(300000.00);
			bidItem.setHoursToBid(2);
			bidItem.setBidCriteria(2);
			bidItem = client.createItem(bidItem);
			System.out.println(bidItem.getItemID());
			assertNotNull(bidItem);
		}
	}
	
	
	@Test
	public void getBidItemDetails() {
		BidderClient client = new BidderClient();
		BidItem bidItem = client.getBidItemDetails("250d7aaabd953d6c2b1603a0d6aea31d");
		System.out.println("Item Price: " + bidItem.getItemName());
		System.out.println("Item Price: " + bidItem.getItemPrice());
	
	}
	
	
	@Test
	public void putBidOnItem() {
		BidderClient client = new BidderClient();
		for(int i=0; i < 4; i++) {
			BidQuote bidQuote = new BidQuote();
			bidQuote.setBidderName("Ram Singh" + i);
			bidQuote.setBidPrice(204849.0 + i);
			BidItem bidItem = client.updateBidOnItem(bidQuote, "250d7aaabd953d6c2b1603a0d6aea31d");
			System.out.println("Item Price: " + bidItem.getItemName());
			System.out.println("Item Price: " + bidItem.getItemPrice());
			//System.out.println("Item Owner: " + bidItem.getItemOwnerUser());
		}
	}
	

	@Test
	public void putBidOnItemLimitTestOnPrice() {
		BidderClient client = new BidderClient();
		BidQuote bidQuote = new BidQuote();
		bidQuote.setBidderName("Ram Singh0");
		bidQuote.setBidPrice(3600000.0);
		BidItem bidItem = client.updateBidOnItem(bidQuote, "250d7aaabd953d6c2b1603a0d6aea31d");
		System.out.println("Item Price: " + bidItem.getItemName());
		System.out.println("Item Price: " + bidItem.getItemPrice());
		//System.out.println("Item Owner: " + bidItem.getItemOwnerUser());
	}
}