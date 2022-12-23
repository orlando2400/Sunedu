package com.app.sunedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sunedu.model.Ubigeo;
import com.app.sunedu.repository.UbigeoRepository;
import com.app.sunedu.service.UbigeoService;

@Service
public class UbigeoServiceImpl implements UbigeoService{
	
	@Autowired
	UbigeoRepository repository;
	
	@Override
	public List<String> listForDepartament() {
		return repository.listDepartament();
	}

	@Override
	public List<String> listForProvince(String departament) {
		return repository.listProvince(departament);
	}

	@Override
	public List<Ubigeo> listForDistrict(String departament, String province) {
		return repository.listDistrict(departament, province);
	}

}
