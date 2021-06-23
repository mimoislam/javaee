package com.octest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Note;
import com.octest.beans.User;

public class NoteD  implements NoteDAO{
	 private DbConnection dbConnection;
	 public NoteD() {
		dbConnection=new DbConnection();
	}
	@Override
	public List<Note> selectAllNote(int user_id) {
		List<Note> notes = new ArrayList<Note>();
		Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        
        try {
        	connection=dbConnection.Connect();
            statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,note, user_id  FROM Notes where user_id =?;");
            preparedStatement.setInt(1, user_id);
            // Ex�cution de la requ�te
            resultat = preparedStatement.executeQuery();

            while (resultat.next()) {
                Note note = new Note();
                note.setId(Integer.parseInt(resultat.getString("id")));
                note.setNote(resultat.getString("note"));
                note.setId(Integer.parseInt(resultat.getString("user_id")));
                notes.add(note);
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return notes;
	}

	@Override
	public Note selectNoteById(int id) {
		Note note=null;
		try {
			// Step 1: Establishing a Connection

			Connection connection = dbConnection.Connect();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select id,note, user_id  from Notes where id =?");
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String text = rs.getString("note");
				int user_id = rs.getInt("user_id");
				note = new Note();
                note.setId(id);
                note.setNote(text);
                note.setUser_id(user_id);
			}
		} catch (SQLException e) {
        	e.printStackTrace();
		}
		return note;	}

	@Override
	public void addNote(Note note) {
		try {
			Connection connection = dbConnection.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Notes	(note, user_id) VALUES(?, ?);");
            preparedStatement.setString(1, note.getNote());
            preparedStatement.setInt(2, note.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteNoteById(int id) {
		try {
			Connection connection = dbConnection.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Notes WHERE id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

	@Override
	public void updateNoteById(Note note, int id) {
		try {
			Connection connection = dbConnection.Connect();
            PreparedStatement preparedStatement = connection.prepareStatement("Update Notes set note = ? where id= ?");
            preparedStatement.setString(1, note.getNote());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}

}
