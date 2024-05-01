package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Songs;

public interface SongService {

	public String addsongs(Songs songs);

	public boolean nameExists(String name);

	public List<Songs> fetchAllSongs();

	public void updateSongs(Songs s);

	

}
