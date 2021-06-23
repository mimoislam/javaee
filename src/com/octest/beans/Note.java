package com.octest.beans;

public class Note {
private String note  ;
private int id;
private int user_id;
public Note() {}
public Note(String note, int user_id ) {
	this.user_id=user_id;
	this.note=note;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
}
