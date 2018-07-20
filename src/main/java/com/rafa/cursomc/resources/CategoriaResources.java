package com.rafa.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rafa.cursomc.domain.Categoria;


//
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "inf");
		Categoria cat2 = new Categoria(1, "escritorio");
		
		List<Categoria> lis = new ArrayList<Categoria>();
		lis.add(cat1);
		lis.add(cat2);
		lis.add(cat2);
		
		
		return lis;
	}
	
}
