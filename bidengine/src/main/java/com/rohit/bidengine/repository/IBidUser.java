package com.rohit.bidengine.repository;

import com.rohit.bidengine.model.Bidder;
import com.rohit.bidengine.model.User;

public interface IBidUser {

	boolean checkIfUserExists(String userName);

	void createBidder(String userName);

	void addUser(User user);

}