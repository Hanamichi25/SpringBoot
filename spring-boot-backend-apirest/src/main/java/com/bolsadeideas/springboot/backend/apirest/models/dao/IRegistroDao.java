package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Registro;

@Repository
public interface IRegistroDao  extends CrudRepository<Registro, Long>{
	
	@Query(value = "SELECT u.id, u.url, u.primernombre, u.segundonombre, u.primerapellido, u.segundoapellido, u.coincidencia " +
			" FROM registros u WHERE CONCAT(u.primernombre,' ',u.segundonombre,' ',u.primerapellido,' ',u.segundoapellido) LIKE %?1%" +
			" and u.coincidencia IN (?2) " +
			" GROUP BY u.id, u.url, u.primernombre, u.segundonombre, u.primerapellido, u.segundoapellido, u.coincidencia",
			  nativeQuery = true)
	List<Registro> findRegistroByTextoCoincidencia(String cadenaTexto, List<String> coincidencias);


	@Query(value = "SELECT * FROM registros u WHERE CONCAT(u.primernombre,' ',u.segundonombre,' ',u.primerapellido,' ',u.segundoapellido) LIKE %?1%",
			nativeQuery = true)
	List<Registro> findRegistroByTextoSinCoincidencia(String cadenaTexto);

}
