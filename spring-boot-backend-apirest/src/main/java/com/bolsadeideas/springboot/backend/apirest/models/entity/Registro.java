package com.bolsadeideas.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registros")
public class Registro implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String url;
	private String primernombre;
	private String segundonombre;
	private String primerapellido;
	private String segundoapellido;
	private String coincidencia;
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}

	

	public String getPrimernombre() {
		return primernombre;
	}



	public void setPrimernombre(String primernombre) {
		this.primernombre = primernombre;
	}



	public String getSegundonombre() {
		return segundonombre;
	}



	public void setSegundonombre(String segundonombre) {
		this.segundonombre = segundonombre;
	}



	public String getPrimerapellido() {
		return primerapellido;
	}



	public void setPrimerapellido(String primerapellido) {
		this.primerapellido = primerapellido;
	}



	public String getSegundoapellido() {
		return segundoapellido;
	}



	public void setSegundoapellido(String segundoapellido) {
		this.segundoapellido = segundoapellido;
	}



	public String getCoincidencia() {
		return coincidencia;
	}



	public void setCoincidencia(String coincidencia) {
		this.coincidencia = coincidencia;
	}





	private static final long serialVersionUID = 1L;
}
