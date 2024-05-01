package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehub.entity.Playlists;

public interface PlaylistsRepository extends JpaRepository<Playlists, Integer> {

}
