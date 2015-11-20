package com.rohit.bidengine;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import com.rohit.bidengine.model.BidItem;
import com.rohit.bidengine.model.Bidder;
import com.rohit.bidengine.model.User;
import com.rohit.bidengine.repository.BidItemStub;
import com.rohit.bidengine.repository.BidderRepository;


/*
http://localhost:8080/bidengine/webapi/bidder				<- POST create bidder
http://localhost:8080/bidengine/webapi/biditem				<- POST create item
http://localhost:8080/bidengine/webapi/biditems				<- Get all bid items
http://localhost:8080/bidengine/webapi/biditem/xxx			<- GET bid item details and status
http://localhost:8080/bidengine/webapi/bidder/biditem/xxx	<- Get top 5 bidder for the item
http://localhost:8080/bidengine/webapi/bidder/biditem/xxx	<- PUT create a bid
*/

@Path("myresource")
public class MyResource {

	BidderRepository bidderRepository = new BidderRepository();
	    
	/*
     *	This web service will return list of all the bid items 
     */
    @GET
    @Path("/biditems")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<BidItem> getBidItems() {
    	System.out.println("This os the function call");
    	return new BidItemStub().getBidItemList();
    }
    
    /*
     * This web service will return details of BidItem for the given bidItemID
     */
    
    @GET
    @Path("/biditem/{bidItemID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public BidItem getBidItemDetailsByItemID(@PathParam("bidItemID") String bidItemID) {
    	return bidderRepository.findBidItemByID(bidItemID);
    }
    
    
    /*
     * This web service will return the top 5 bidders for the item
     * 
     */
    @GET
    @Path("/bidder/biditem/{bidItemID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public BidItem getTopBiddersForTheItemByItemID(@PathParam("bidItemID") String bidItemID) {
    	return bidderRepository.findBidItemByID(bidItemID);
    }
    
    /*
     * This web service will create a bid item
     */
    @POST
	@Path("/biditem")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public BidItem createABidItem(BidItem bidItem) {		
    	return bidderRepository.createABidItem(bidItem);
	}
    
    /*
     * This web service call will create a bidder i.e., register a user
     */
    @POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User createAUser(User user) {		
    	return bidderRepository.createBidder(user);
	}
    
    /*
     * This web service call will create a bid on an BidItem against its ItemID
     */
    @PUT
    @Path("/biditem/{bidItemID}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public BidItem updateBidItemDetails(@PathParam("bidItemID") String bidItemID) {
    	return bidderRepository.findBidItemByID(bidItemID);
    }
       
    @PostConstruct
    void loadConfiguration() {
    	//Create a thread to do the monitoring for closing bids
    }
}
