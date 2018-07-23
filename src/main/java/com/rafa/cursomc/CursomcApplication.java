package com.rafa.cursomc;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafa.cursomc.domain.Categoria;
import com.rafa.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	// ao iniciar faz algo
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		repo.saveAll(Arrays.asList(cat1,cat2));
	}
}
