package com.csmtech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csmtech.model.LibraryMaster;

@Service
public interface LibraryService {
	List<LibraryMaster> getAllLibrary();

	LibraryMaster getById(Integer libraryId);

}
