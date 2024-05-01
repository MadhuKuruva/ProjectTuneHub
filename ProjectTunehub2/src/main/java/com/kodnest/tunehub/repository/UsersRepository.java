package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehub.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

	public Users findByEmail(String email);


	

	

}
