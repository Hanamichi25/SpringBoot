package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Registro;

public interface IRegistroService {
	
	public List<Registro> finAllRegistros();
	
	public List<Registro> findByTexto(String cadenaTexto);
	
}
