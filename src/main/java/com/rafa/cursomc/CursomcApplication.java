package com.rafa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafa.cursomc.domain.Categoria;
import com.rafa.cursomc.domain.Produto;
import com.rafa.cursomc.repositories.CategoriaRepository;
import com.rafa.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository prod;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	// ao iniciar faz algo
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		 Produto p1 = new Produto(null, "Computador", 2000.0);
		 Produto p2 = new Produto(null, "Impressora", 800.0);
		 Produto p3 = new Produto(null, "mouse", 80.0);
		 
		 cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		 cat2.getProdutos().addAll(Arrays.asList(p2));
		
		 p1.getCategorias().addAll(Arrays.asList(cat1));
		 p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		 p3.getCategorias().addAll(Arrays.asList(cat1));
		
		repo.saveAll(Arrays.asList(cat1,cat2));
		prod.saveAll(Arrays.asList(p1,p2,p3));
	}
}
