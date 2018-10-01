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


import com.test.messenger.messenger_api.model.Message;
import com.test.messenger.messenger_api.services.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages()
	{
		return messageService.getAllMessages();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id)
	{
		return messageService.getMessage(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMesssage(Message message)
	{
		
		return messageService.addMessage(message);
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public void removeMessage(@PathParam("messageId") long id)
	{
		 messageService.removeMessage(id);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public void updateMessage(@PathParam("messageId") long id,Message message)
	{
		message.setId(id);
		messageService.updateMessage(message);
	}

	

}
