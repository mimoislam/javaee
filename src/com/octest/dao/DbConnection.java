package com.octest.dao;

import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Note;
import com.octest.beans.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DbConnection   {
	private String dbUsername="root";
	private String dbPassword="root";
	private String dbLink="jdbc:mysql://localhost:3306/appdist";
	
	// constructeurs
	public DbConnection()  {
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        	e.getMessage();
	        }
	}
	
	public DbConnection(String link, String username, String password)  {
		dbLink=link;
		dbPassword=password;
		dbUsername=username;
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        	e.getMessage();
	        }
	}
	
	
	public Connection Connect() throws SQLException {
		return DriverManager.getConnection(dbLink, dbUsername, dbPassword);
    }
	
	
	
	

	

}
