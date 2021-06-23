package com.octest.beans;

public class User {
	protected int id;
	protected String username ;
	protected String password ;
	protected String email;

public User() {
	
}
public User( int id,String username , String password , String email) {
	this.id=id;
this.email=email;
this.password=password;
this.username=username;
}
public User( String username , String password , String email) {
this.email=email;
this.password=password;
this.username=username;
}
public User( String username , String password ) {
this.password=password;
this.username=username;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
