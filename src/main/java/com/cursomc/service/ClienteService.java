package com.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Cliente;
import com.cursomc.repository.ClienteRepository;
import com.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> buscar() {
		return repo.findAll();
	}
	
	public Cliente buscarPorId(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException(
											"Objeto não encontrado! Id:" + id + 
											", Tipo: " + Cliente.class.getName()));
	}
}
