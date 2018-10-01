package com.test.messenger.messenger_api.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.test.messenger.messenger_api.database.CRUDOperations;
import com.test.messenger.messenger_api.database.DatabaseClass;
import com.test.messenger.messenger_api.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	Message m1 = new Message(1, "hi prateek", "prateek");

	public List<Message> getAllMessages() {
		List<Message> messageList = new ArrayList<>();
		try {
			System.out.println("#######");
			ResultSet rs = CRUDOperations.getAllMessages();
			System.out.println(rs.toString());
			while (rs.next()) {
				Message message = new Message();
				message.setAuthor(rs.getString("author"));
				String dateCreated=rs.getString("created");
				message.setId(Long.parseLong(rs.getString("message_id")));
				messageList.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return messageList;
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		try {
			CRUDOperations.addDetails(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() < 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		if (id < 0) {
			return null;
		}
		messages.remove(id);
		return messages.get(id);
	}

}
