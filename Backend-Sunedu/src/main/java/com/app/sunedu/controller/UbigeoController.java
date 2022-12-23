package com.app.sunedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.sunedu.model.Ubigeo;
import com.app.sunedu.service.UbigeoService;

@RestController
@RequestMapping("/ubigeo")
@CrossOrigin("*")
public class UbigeoController {
	
	@Autowired
	UbigeoService service;
	
	//Obtener lista de departamentos
	@GetMapping("/departmentList")
	public List<String> departamentList(){
		return service.listForDepartament();
	}
	
	//Obtener lista de provincias
	@GetMapping("/provinceList/{dep}")
	public List<String> provinceList(@PathVariable String dep){
		return service.listForProvince(dep);
	}
	//Obtener lista de distritos
	@GetMapping("/districtList/{dep}/{dis}")
	public List<Ubigeo> districtList(@PathVariable String dep,@PathVariable String dis){
		return service.listForDistrict(dep, dis);
	}
}
