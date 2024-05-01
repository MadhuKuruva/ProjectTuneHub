package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehub.entity.Songs;

public interface SongRepository extends JpaRepository<Songs, Integer> {

	Songs findByName(String name);

	

}
