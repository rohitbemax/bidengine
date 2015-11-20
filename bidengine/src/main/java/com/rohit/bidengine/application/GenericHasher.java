package com.rohit.bidengine.application;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenericHasher {
	
	//Using MD5 hash to ensure the item is unique and avoid collision
	public static String generateIDForItem(String userName, String itemName) 
	{
		String hashString = userName + itemName;
		return generateHashFromString(hashString);
	}

	public static String generateIDFromUserName(String username) 
	{
		return generateHashFromString(username);
	}
	
	public static String generateHashFromString(String strToHash) 
	{	
		String hashID = "";
	
		try 
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte messageDigest[] = md.digest(strToHash.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
	        hashID = number.toString(16);
	        return hashID;
		} 
		catch (NoSuchAlgorithmException e) 
		{
			return hashID;
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Hash: " + new GenericHasher().generateIDForItem("Rohit", "Application"));
		System.out.println("Hash: " + new GenericHasher().generateIDForItem("Rohit", "Application"));
		System.out.println("Hash: " + new GenericHasher().generateIDForItem("Rohit", "Application"));
	}
}
