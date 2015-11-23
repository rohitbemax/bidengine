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
		
		assertNotNull(user);
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
			bidItem.setBidCriteria(1);
			bidItem = client.createItem(bidItem);
			//System.out.println(bidItem.getItemID());
			assertNotNull(bidItem);
		}
	}
	
	@Test
	public void getBidItemDetails() {
		BidderClient client = new BidderClient();
		BidItem bidItem = client.getBidItemDetails("9e6c2e70ce2c9450d7ee375d7334578");
		System.out.println("Item Price: " + bidItem.getItemName());
		System.out.println("Item Price: " + bidItem.getItemPrice());
	
	}
	

	@Test
	public void putBidOnItem() {
		BidderClient client = new BidderClient();
		for(int i=0; i < 10; i++) {
			BidQuote bidQuote = new BidQuote();
			//bidQuote.setItemID("9e6c2e70ce2c9450d7ee375d7334578");
			bidQuote.setBidderName("Ram Singh" + i);
			bidQuote.setBidPrice(204849.0 + i);
			BidItem bidItem = client.updateBidOnItem(bidQuote, "9e6c2e70ce2c9450d7ee375d7334578");
			System.out.println("Item Price: " + bidItem.getItemName());
			System.out.println("Item Price: " + bidItem.getItemPrice());
			//System.out.println("Item Owner: " + bidItem.getItemOwnerUser());
		}
	}
}