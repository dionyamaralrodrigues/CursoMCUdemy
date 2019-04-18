package com.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.domain.Categoria;
import com.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> buscar() {
		return repo.findAll();
	}
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> obj = repo.findById(id); 
		return obj.orElse(null);
	}
}
