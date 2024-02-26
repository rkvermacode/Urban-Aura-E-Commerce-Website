package com.rkvermacode.DAO;

import com.rkvermacode.Entity.User;

public interface UserDAO {

	public boolean userRegister(User user);
	
	public User login(String email, String password);
	
	public boolean checkPassword(int id, String pass);
	
	public boolean updateProfile(User user);
	
	public boolean checkUser(String email);
}
