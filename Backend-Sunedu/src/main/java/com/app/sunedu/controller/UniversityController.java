package com.app.sunedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.sunedu.model.University;
import com.app.sunedu.service.UniversityService;

@RestController
@RequestMapping("/teacher")
public class UniversityController {
	
	//Inyectar interfaz servicio teacher
	@Autowired
	UniversityService uService;
	
	@PostMapping("/register")
	public University register(@RequestBody University university) {
		return uService.register(university);
	}
	@PutMapping("/update")
	public University update(@RequestBody University university) {
		return uService.register(university);
	}
	
	@GetMapping("/list/")
	public List<University> listUniversity(@PathVariable String name, @PathVariable String type, @PathVariable Long idUbigeo, @PathVariable String state){
		return uService.listForAll(name, type, idUbigeo, state);
	}
	@GetMapping("list/{username}")
	public List<University> listForName(@PathVariable String username){
		List<University> salida = null;
		try {
			if(username.equals("")) {
				salida = uService.listName("%");
			}
			else {
				salida = uService.listName("%"+username+"%");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return salida ;
	}
	
	@DeleteMapping("/delete/{idUniversity}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long idUniversity) {
		uService.delete(idUniversity);
	}
}