package com.octest.dao;

import com.octest.beans.User;
import java.util.List;

public interface UserDAO {
	List<User> selectallusers();
	User selectuserbyid(int id);
	void adduser(User user);
	void deleteuserbyid(int id);
	void updateuserbyid(User user,int id);
}
