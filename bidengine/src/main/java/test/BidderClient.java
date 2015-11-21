package test;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rohit.bidengine.model.*;


public class BidderClient {

	private Client client;

	public BidderClient() {
		client = ClientBuilder.newClient();
	}
	
	
	public Bidder get(String id) {
		
		//http://localhost:8080/exercise-services/webapi/activities/1234
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
		Response response = target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(Bidder.class);
	}
	
	public List<User> get () {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
		List<User> response = target.path("activities").request(MediaType.APPLICATION_JSON).get(new GenericType<List<User>>() {});
		
		return response;
	}

	public User create(User user) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("myresource/user")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(User.class);
	}
	
	public BidItem createItem(BidItem activity) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("myresource/biditem")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(BidItem.class);
	}
	
	public BidItem createBid(BidItem activity) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("myresource/biditem")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(BidItem.class);
	}
	
	public BidItem placeNewBid(BidItem activity) {
		WebTarget target = client.target("http://localhost:8080/bidengine/webapi/");
		
		Response response = target.path("myresource/biditem")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(BidItem.class);
	}
	
	/*
	public void delete(String activityId) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
		Response response = target.path("activities/" + activityId).request(MediaType.APPLICATION_JSON).delete();
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
	}
	*/


	/*
	public Activity update(Activity activity) {
		WebTarget target = client.target("http://localhost:8080/exercise-services/webapi/");
		
		Response response = target.path("activities/" + activity.getId())
				.request(MediaType.APPLICATION_JSON)
				.put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		
		if(response.getStatus() != 200) {
			throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
		}
		
		return response.readEntity(Activity.class);
	}
	*/
}
