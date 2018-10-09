package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Registro;

@Repository
public interface IRegistroDao  extends CrudRepository<Registro, Long>{
	
	@Query(value = "SELECT * FROM registros u WHERE u.primernombre ||"+" \"' '\" "+"|| u.segundonombre || u.primerapellido LIKE %?1%", 
			  nativeQuery = true)
	List<Registro> findRegistroByTexto(String cadenaTexto);
	
}
