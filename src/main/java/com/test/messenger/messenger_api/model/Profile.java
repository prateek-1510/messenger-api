package com.test.messenger.messenger_api.model;

public class Profile {
	private String profileName;
	private String firstName;
	private String lastName;
	private String address;
	public Profile(String profileName, String firstName, String lastName, String address) {
		super();
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	public Profile()
	{
		
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
