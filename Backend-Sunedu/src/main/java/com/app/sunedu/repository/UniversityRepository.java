package com.app.sunedu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.sunedu.model.University;

public interface UniversityRepository extends JpaRepository<University, Long>{
	@Query("select u from University u where (?1 is '' or u.name like ?1) and (?2 is '' or u.type = ?2) and (?3 is -1 or u.ubigeo.idUbigeo = ?3) and u.state = ?4")       
	public List<University> list(String name, String type, Long idUbigeo, String state);

	@Query("select u from University u where u.name like ?1")
	public List<University> listForName(String name);
	
	public University findByCodigoEntidad(Integer codigoEntidad);
}
