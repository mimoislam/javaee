package com.octest.dao;

import java.util.List;

import com.octest.beans.Note;

public interface NoteDAO {
	List<Note> selectAllNote(int user_id);
	Note selectNoteById(int id);
	void addNote(Note user);
	void deleteNoteById(int id);
	void updateNoteById(Note user,int id);
}
