package com.example.springboot.app.models.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.models.entity.Cliente;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		entityManager.persist(cliente);
	}

}
