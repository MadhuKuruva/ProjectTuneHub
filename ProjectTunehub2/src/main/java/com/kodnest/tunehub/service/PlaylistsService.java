package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Playlists;

public interface PlaylistsService {

	public void addplaylist(Playlists playlists);

	public List<Playlists> fetchAllPlaylists();

}
