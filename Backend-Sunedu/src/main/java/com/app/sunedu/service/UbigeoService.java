package com.app.sunedu.service;

import java.util.List;

import com.app.sunedu.model.Ubigeo;

public interface UbigeoService {

	public List<String> listForDepartament();
	public List<String> listForProvince(String departament);
	public List<Ubigeo> listForDistrict(String departament,String province);
}
