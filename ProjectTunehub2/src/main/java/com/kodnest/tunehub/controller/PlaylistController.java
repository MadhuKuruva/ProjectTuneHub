package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Playlists;
import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.service.PlaylistsService;
import com.kodnest.tunehub.service.SongService;

@Controller
public class PlaylistController {
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistsService playlistsService;
	
	@GetMapping("/createplaylists")
	public String createPlaylists(Model model) {
		List<Songs> songList = songService.fetchAllSongs();
		model.addAttribute("songss",songList);
		return "createplaylists";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlists playlists) {
		//updating the playlist table
		playlistsService.addplaylist(playlists);
		
		//updating the song table
		List<Songs> songList = playlists.getSongs();
		for(Songs s : songList) {
			s.getPlaylists().add(playlists);
			songService.updateSongs(s);
		}
		
		
		return "admin";
	}
	@GetMapping("/viewplaylists")
	public String viewPlaylists(Model model) {
		List<Playlists> playlist = playlistsService.fetchAllPlaylists();
		
		model.addAttribute("playlists",playlist);
		return "displayplaylists";
	}
	

}
