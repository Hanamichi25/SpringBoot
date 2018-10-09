package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.List;
import java.util.Optional;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Coincidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping(path="/registroFiltro/{cadenaTexto}", consumes="application/json")
	public List<Registro> obtenerRegistrosPorCoincidencia(@PathVariable Optional<String> cadenaTexto, @RequestBody Coincidencia coincidencias) {
		String texto = "";
		if(cadenaTexto.isPresent()){
			texto = cadenaTexto.get();
		}
		if(coincidencias.getCoincidencias().size() > 0){
			List<Registro> listaResponse = registroService.findByTextoConCoincidencia(texto, coincidencias.getCoincidencias());
			if(listaResponse.size() < 3){
				listaResponse.clear();
			}
			return listaResponse;
		}else{
			return registroService.findByTextoSinCoincidencia(texto);
		}

	}
	
}
