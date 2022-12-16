package com.app.sunedu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "ubigeos")
public class Ubigeo implements Serializable{
	
	@Id
	@Column(name = "id_ubigeo")
	private String idUbigeo;
	private String departament;
	private String district;
	private String province;
	private static final long serialVersionUID = 1L;
}
