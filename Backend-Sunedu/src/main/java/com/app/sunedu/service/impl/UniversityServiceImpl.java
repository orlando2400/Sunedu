package com.app.sunedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sunedu.model.University;
import com.app.sunedu.repository.UniversityRepository;
import com.app.sunedu.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {
	
	@Autowired
	UniversityRepository repository;
	
	@Override
	public University register(University university) {
		return repository.save(university);
	}

	@Override
	public void delete(Long idUniversity) {
		repository.deleteById(idUniversity);
	}
	
	@Override
	public List<University> listForAll(String name, String type, Long idUbigeo, String state) {
		return repository.list(name, type, idUbigeo, state);
	}
	
	@Override
	public List<University> listName(String name) {
		return repository.listForName(name);
	}

	

	

}
