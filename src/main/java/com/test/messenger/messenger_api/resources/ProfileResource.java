package com.test.messenger.messenger_api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.test.messenger.messenger_api.model.Profile;
import com.test.messenger.messenger_api.services.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	ProfileService profileService=new ProfileService();
	@GET
	public List<Profile> getAllProfiles()
	{
		return profileService.getAllProfiles();
	}
	@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId")String profileName)
	{
		return profileService.getProfile(profileName);
	}
	@POST
	public Profile addProfile(Profile profile)
	{
		return profileService.addProfile(profile, profile.getProfileName());
	}
	@PUT
	@Path("/{profileId}")
	public void updateProfile(@PathParam("profileId")String profileName,Profile profile)
	{
		profileService.updateProfile(profile, profileName);
		
	}
	@DELETE
	@Path("/{profileId}")
	public Profile removeProfile(@PathParam("profileId") String profileName,Profile profile)
	{
		return profileService.removeProfile(profile, profileName);
	}
	

}
