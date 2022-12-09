package com.app.sunedu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.sunedu.model.Ubigeo;

public interface UbigeoRepository extends JpaRepository<Ubigeo, Long>{
	@Query("select distinct u.departament from Ubigeo u order by 1 asc")
	public abstract List<String> listDepartament();
	
	@Query("select distinct u.province from Ubigeo u where u.departament = :var_dep  order by 1 asc")
	public abstract List<String> listProvince(@Param("var_dep") String departamento);  

	@Query("select u from Ubigeo u where u.departament = :var_dep and u.province = :var_pro  order by u.district asc")
	public abstract List<Ubigeo> listDistrict(@Param("var_dep") String departament,@Param("var_pro") String province);
}
