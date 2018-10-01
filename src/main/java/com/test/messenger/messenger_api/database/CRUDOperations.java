package com.test.messenger.messenger_api.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.messenger.messenger_api.model.Message;

public class CRUDOperations {
	private static Connection con;
	private static PreparedStatement psmt;
	private static final String insertDetails="INSERT INTO MESSENGER_MESSAGES "
			+ "(message_id,message,author) VALUES(?,?,?)";
	private static final String getMessageList="SELECT * FROM MESSENGER_MESSAGES";
		public static boolean addDetails(Message message) throws SQLException
		{
			if(con==null)
			{
				return false;
			}
			psmt=con.prepareStatement(insertDetails);
			psmt.setLong(1,message.getId());
			psmt.setString(2,message.getMessage());
			//psmt.setString(3,message.getCreated().toString());
			psmt.setString(3,message.getAuthor());
			int inserted=psmt.executeUpdate();
			if(inserted>0)
			{
				System.out.println("record inserted successfully");
				return true;
			}
			else
			{
				System.out.println("record insertion failed");
				return false;
			}
			
			
		}
		public boolean updateDetails(String query)
		{
			if(con==null)
			{
				return false;
			}
			return true;
		}
		public boolean removeDetails(String query)
		{
			if(con==null)
			{
				return false;
			}
			return true;
		}
		public static ResultSet getAllMessages() throws SQLException
		{
			
				con=Messenger_DBConnection.getDBConnection();
			
			psmt=con.prepareStatement(getMessageList);
			ResultSet messages=psmt.executeQuery();
			return messages;
			
		}
		

}
