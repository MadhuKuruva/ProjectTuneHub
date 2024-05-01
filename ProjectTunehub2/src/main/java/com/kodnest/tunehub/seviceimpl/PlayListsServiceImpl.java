package com.kodnest.tunehub.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlists;
import com.kodnest.tunehub.repository.PlaylistsRepository;
import com.kodnest.tunehub.service.PlaylistsService;

@Service
public class PlayListsServiceImpl implements PlaylistsService {

	@Autowired
	PlaylistsRepository playlistsRepository;

	@Override
	public void addplaylist(Playlists playlists) {

		playlistsRepository.save(playlists);
	}

	@Override
	public List<Playlists> fetchAllPlaylists() {
		List<Playlists> allplaylist = playlistsRepository.findAll();
		return allplaylist;
	}
}
