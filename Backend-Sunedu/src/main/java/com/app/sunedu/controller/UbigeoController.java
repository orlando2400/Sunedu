package com.app.sunedu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.sunedu.model.Ubigeo;

@RestController
@RequestMapping(name = "/ubigeo")
public class UbigeoController {
	
	
	//Obtener lista de departamentos
	@GetMapping("/departmentList")
	public List<Ubigeo> departamentList(){
		return null;
	}
	
	//Obtener lista de provincias
	@GetMapping("/provinceList/{dep}")
	public List<Ubigeo> provinceList(@PathVariable String dep){
		return null;
	}
	//Obtener lista de distritos
	@GetMapping("/districtList/{dep}/{dis}")
	public List<Ubigeo> districtList(@PathVariable String dep,@PathVariable String dis){
		return null;
	}
}
