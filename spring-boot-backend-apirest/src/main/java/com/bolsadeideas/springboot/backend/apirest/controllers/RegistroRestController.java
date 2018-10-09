package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Registro;
import com.bolsadeideas.springboot.backend.apirest.models.services.IRegistroService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RegistroRestController {
	
	@Autowired
	private IRegistroService registroService;
	
	@GetMapping("/registros")
	public List<Registro> index() {
		return registroService.finAllRegistros();
	}	
	
	@GetMapping("/registroFiltro/{cadenaTexto}")
	public List<Registro> obtenerRegistrosPorCoincidencia(@PathVariable String cadenaTexto) {
		String texto = cadenaTexto;
		System.out.println("Obteniendo cadena "+texto);
		return registroService.findByTexto(cadenaTexto);
	}
	
}
