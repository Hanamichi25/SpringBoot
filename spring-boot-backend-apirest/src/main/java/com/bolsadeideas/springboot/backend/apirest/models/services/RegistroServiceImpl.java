package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IRegistroDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Registro;
@Service
public class RegistroServiceImpl implements IRegistroService{

	@Autowired
	private IRegistroDao registroDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Registro> finAllRegistros() {
		return (List<Registro>) registroDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Registro> findByTextoConCoincidencia(String cadenaTexto, List<String> coincidencias) {
		// TODO Auto-generated method stub
		return (List<Registro>) registroDao.findRegistroByTextoCoincidencia(cadenaTexto,coincidencias);
	}

	@Override
	public List<Registro> findByTextoSinCoincidencia(String cadenaTexto) {
		return (List<Registro>) registroDao.findRegistroByTextoSinCoincidencia(cadenaTexto);
	}
}
