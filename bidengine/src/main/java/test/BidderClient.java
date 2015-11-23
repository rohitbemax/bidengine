package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rohit.bidengine.model.*;


public class BidderClient {

	private Client client;

	public BidderClient() {
		client = ClientBuilder.newClient();
	}
	
	public User create(User user) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("bidservices/user")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(User.class);
	}
	
	public BidItem createItem(BidItem bidItem) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("bidservices/biditem")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(bidItem, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(BidItem.class);
	}
	
	public BidItem getBidItemDetails(String bidItemID) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("bidservices/biditem/" + bidItemID).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(BidItem.class);
	}
	
	public BidItem createBid(BidItem activity) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("bidservices/biditem")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(BidItem.class);
	}
	
	public BidItem updateBidOnItem(BidQuote bidQuote, String bidItemID) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("bidservices/biditem/" + bidItemID)
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(bidQuote, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(BidItem.class);
	}
}
