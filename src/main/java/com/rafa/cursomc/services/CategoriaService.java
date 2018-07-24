package com.rafa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafa.cursomc.domain.Categoria;
import com.rafa.cursomc.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException{
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				
				"Objeto não encontrado" + id + ", Tipo " + Categoria.class.getName()));
		
	}

}
