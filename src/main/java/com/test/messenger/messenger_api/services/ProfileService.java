package com.test.messenger.messenger_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.test.messenger.messenger_api.database.DatabaseClass;
import com.test.messenger.messenger_api.model.Profile;

public class ProfileService {
	Map<String, Profile> profiles=DatabaseClass.getProfiles();
	Profile p1=new Profile("default","","","");
	public List<Profile> getAllProfiles()
	{
		profiles.put("preset",p1);
		return new ArrayList<>(profiles.values());
	}
	public Profile getProfile(String profileName)
	{
		if(profiles.containsKey(profileName))
		{
			return profiles.get(profileName);
		}
		return null;
	}
	public Profile addProfile(Profile profile,String profileName)
	{
		if(!profiles.containsKey(profileName))
		{
			profiles.put(profileName, profile);
			return profile;
		}
		return null;
		
		
	}
	public Profile removeProfile(Profile profile,String profileName)
	{
		if(!profiles.containsKey(profileName))
		{
			return null;
		}
		profiles.remove(profileName);
		return profile;
		
	}
	public Profile updateProfile(Profile profile,String profileName)
	{
		if(profiles.containsKey(profileName))
		{
			profiles.put(profileName, profile);
			return profile;
		}
		return null;
	}

}
