package com.kodnest.tunehub.controller;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.service.SongService;


import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class SongController {
	
	@Autowired
	SongService songService;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Songs songs) {
		String name = songs.getName();
		boolean result = songService.nameExists(name);
		if(result==true) {
			System.out.println("Song already exists");
		}
		else {
		songService.addsongs(songs);
		System.out.println("Song added Successfully");
		}
		return "admin";
		
		
	}
	
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<Songs> songList = songService.fetchAllSongs();
		model.addAttribute("songss",songList);
		return "displaysongs";
	}
	
	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		
		boolean premium=true;
		if(premium == true) {
		List<Songs> songList = songService.fetchAllSongs();
		model.addAttribute("songss",songList);
		return "displaysongs";
		}
		else {
			return "subscriptionform";
		}
	}
	

}
