package com.csmtech.service;

import java.util.List;

import com.csmtech.model.LibraryMaster;

public interface LibraryService {
	List<LibraryMaster> getAllLibrary();

	LibraryMaster getById(Integer libraryId);

}
