package com.kodnest.tunehub.service;

import com.kodnest.tunehub.entity.Users;

public interface UsersService {
	
	public String addUser(Users users);

	public boolean emailExists(String email);

	public boolean validateUser(String email, String password);

	public String getRole(String email);
	
	public Users getUser(String email);
	
	public void updateUser(Users user);

	


}
