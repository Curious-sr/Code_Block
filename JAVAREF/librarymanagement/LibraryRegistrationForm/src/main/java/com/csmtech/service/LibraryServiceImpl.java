package com.csmtech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csmtech.model.Library;
import com.csmtech.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public List<Library> getAllLibraries() {
		
		return  (List<Library>) libraryRepository.findAll();
	}

}
