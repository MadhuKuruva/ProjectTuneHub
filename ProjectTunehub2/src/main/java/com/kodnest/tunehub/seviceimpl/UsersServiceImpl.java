package com.kodnest.tunehub.seviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Users;
import com.kodnest.tunehub.repository.UsersRepository;
import com.kodnest.tunehub.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRepository usersRepository;
	
	public String addUser(Users users) {
		usersRepository.save(users);
		return "User added successfully";
	}

	//logic to check the duplicate entries
	@Override
	public boolean emailExists(String email) {
		if(usersRepository.findByEmail(email) == null) {
		
		return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean validateUser(String email, String password) {

		Users byEmail = usersRepository.findByEmail(email);
		
		String dbpwd = byEmail.getPassword();
		
		if(password.equals(dbpwd)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public String getRole(String email) {

		Users user = usersRepository.findByEmail(email);
		
		return user.getRole();
		
		
	}

	@Override
	public Users getUser(String email) {
		return usersRepository.findByEmail(email);
		
	}

	@Override
	public void updateUser(Users user) {
		usersRepository.save(user);
		
	}

	

}
