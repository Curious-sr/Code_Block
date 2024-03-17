package com.csmtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.csmtech.model.Sports;

public interface SportsRepository extends JpaRepository<Sports, Integer>{

	@Query("From Sports where club.clubId=:clubId")
	List<Sports> allSportsList(Integer clubId);

}
