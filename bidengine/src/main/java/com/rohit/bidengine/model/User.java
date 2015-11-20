package com.rohit.bidengine.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}