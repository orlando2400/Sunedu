package com.app.sunedu.service;

import java.util.List;

import com.app.sunedu.model.University;

public interface UniversityService {
	public University register(University university);
	public University update(University university);
	public List<University> listName(String name);
	public List<University>listForAll(String name, String type, Long idUbigeo, String state);
	public void delete(Long idUniversity);
}
