package com.csmtech.service;

import java.util.List;

import com.csmtech.model.Sports;

public interface SportsService {

	List<Sports> allSportsList(Integer clubId);

}
