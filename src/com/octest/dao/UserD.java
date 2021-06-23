package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.User;

public class UserD implements UserDAO {
		 private DbConnection dbConnection;
	 public UserD() {
		dbConnection=new DbConnection();
	}
	@Override
	public List<User> selectallusers() {
		List<User> users = new ArrayList<User>();
		Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        try {
        	connection=dbConnection.Connect();
            statement = connection.createStatement();

            // Ex�cution de la requ�te
            resultat = statement.executeQuery("SELECT id,username, email, password FROM users;");

            // R�cup�ration des donn�es
            while (resultat.next()) {
                User user = new User();
                user.setId(Integer.parseInt(resultat.getString("id")));
                user.setUsername(resultat.getString("username"));
                user.setEmail(resultat.getString("email"));
                user.setPassword(resultat.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return users;
	}

	@Override
	public User selectuserbyid(int id) {
		User user=null;
		try {
			// Step 1: Establishing a Connection

			Connection connection = dbConnection.Connect();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select id,username, email, password from users where id =?");
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
			}
		} catch (SQLException e) {
        	e.printStackTrace();
		}
		return user;
	}
	public User CheckUserLogin(User use) {
		User user=null;
		try {
			// Step 1: Establishing a Connection

			Connection connection =dbConnection. Connect();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select id,username, email, password from Users where username =? && password =?");
			preparedStatement.setString(1, use.getUsername());
			preparedStatement.setString(2, use.getPassword());

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			user=null;
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
			}
		} catch (SQLException e) {
        	e.printStackTrace();
		}
		return user;
	}

	@Override
	public void adduser(User user) {
		try {
			Connection connection = dbConnection.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users	(username, email, password) VALUES(?, ?, ?);");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteuserbyid(int id) {
		try {
			Connection connection = dbConnection.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateuserbyid(User user, int id) {
		try {
			Connection connection = dbConnection.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("Update users set username = ?,email= ?,password= ? where id= ?");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
