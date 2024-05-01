package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.entity.Users;
import com.kodnest.tunehub.service.SongService;
import com.kodnest.tunehub.service.UsersService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users users) {
		
		//email taken from registration form
		String email = users.getEmail();
		
		//checking if the email entered in registration form is present or not
		boolean status = usersService.emailExists(email);
		if(status == false) {
	    
		usersService.addUser(users);
		System.out.println("User added successfully");
		}
		else {
			System.out.println("User already exixts");
		}
		return "login";
	}
	
	
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam("password") String password, HttpSession session, Model model) {
		
		Users user = usersService.getUser(email);
		
		if(user!=null && usersService.validateUser(email,password)){
			
			
			String role = usersService.getRole(email);
			
			session.setAttribute("email", email);
			if(role.equals("admin")) {
			return "admin";
			}
			else {
				
				Users userr = usersService.getUser(email);
				boolean userStatus = userr.isPremium();
				
				List<Songs> fetchAllSongs = songService.fetchAllSongs();
				
				model.addAttribute("songss", fetchAllSongs);
				model.addAttribute("ispremium", userStatus);
				
				return "customer";
			}
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	

}
