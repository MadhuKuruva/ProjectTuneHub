package com.kodnest.tunehub.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository songRepository;
	
	
	@Override
	public String addsongs(Songs songs) {
		songRepository.save(songs);
		return "Song added Successfully";
		
	}


	@Override
	public boolean nameExists(String name) {
		if(songRepository.findByName(name)==null) {
		return false;
		}
		else {
			return true;
		}
	}


	@Override
	public List<Songs> fetchAllSongs() {
		List<Songs> songs = songRepository.findAll();
		return songs;
	}


	@Override
	public void updateSongs(Songs s) {
		songRepository.save(s);
		
	}
	
	

}
