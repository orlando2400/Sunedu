package com.app.sunedu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Table(name = "university")
public class University implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUniversity;
	private Integer codigoEntidad;
	private String name;
	private String type;
	private String state;
	private String startLicense;
	private String endLicense;
	@ManyToOne
	@JoinColumn(name = "idUbigeo")
	private Ubigeo ubigeo;
	private static final long serialVersionUID = 1L;
}
