package com.rohit.bidengine.repository;

import java.util.HashMap;
import com.rohit.bidengine.model.User;

public class BidUserStub implements IBidUser {

	private static HashMap<String, User> usersMap;
	
	public static HashMap<String, User> getInstance() {
		if(usersMap == null) {
			usersMap = new HashMap<String, User>();
			return usersMap;
		} else {
			return usersMap;
		}
	}
	
	@Override
	public boolean checkIfUserExists(String userName) {
		return usersMap.containsKey(userName);
	}
	
	@Override
	public void createBidder(String userName) {
		if(checkIfUserExists(userName)) {
			return;
		} else {
			//addBidder(new Bidder(userName));
		}
	}

	@Override
	public void addUser(User user) {
		usersMap.put(user.getUserName(), user);
		
	}
}