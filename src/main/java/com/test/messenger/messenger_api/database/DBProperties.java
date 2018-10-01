package com.test.messenger.messenger_api.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties {
	
	private Properties properties;
	private String dbUser;
	private String dbPassword;
	private String dbConnectionURL;
	
	
	public DBProperties() throws FileNotFoundException, IOException {
		Properties properties=new Properties();	  
		  String resourceName = "database.properties";
		  ClassLoader loader = Thread.currentThread().getContextClassLoader();
		  try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			  properties.load(resourceStream);
		  }
		  this.properties=properties;
		  System.out.println("???"+properties.toString());
		  System.out.println(getDbUser() );
		  getDbPassword();
		  getDbConnectionURL();
		  
	}
	
	public String getDbUser() {
		this.dbUser=properties.getProperty("user");
		return dbUser;
	}
	
	public String getDbPassword() {
		this.dbPassword = properties.getProperty("password");
		return dbPassword;
	}

	public String getDbConnectionURL() {
		
		this.dbConnectionURL = properties.getProperty("connectionurl");
		return dbConnectionURL;
	}

	
	

}
