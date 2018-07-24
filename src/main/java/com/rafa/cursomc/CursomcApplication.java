package com.rafa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafa.cursomc.domain.Categoria;
import com.rafa.cursomc.domain.Cidade;
import com.rafa.cursomc.domain.Cliente;
import com.rafa.cursomc.domain.Endereco;
import com.rafa.cursomc.domain.Estado;
import com.rafa.cursomc.domain.Produto;
import com.rafa.cursomc.domain.enums.TipoCliente;
import com.rafa.cursomc.repositories.CategoriaRepository;
import com.rafa.cursomc.repositories.CidadeRepository;
import com.rafa.cursomc.repositories.ClienteRepository;
import com.rafa.cursomc.repositories.EnderecoRepository2;
import com.rafa.cursomc.repositories.EstadoRepository;
import com.rafa.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repo;

	@Autowired
	private ProdutoRepository prod;
	
	@Autowired
	private EstadoRepository estRepo;
	
	@Autowired
	private CidadeRepository cidRepo;
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private EnderecoRepository2 endRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	// ao iniciar faz algo
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "mouse", 80.0);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		repo.saveAll(Arrays.asList(cat1, cat2));
		prod.saveAll(Arrays.asList(p1, p2, p3));

		Cidade c1 = new Cidade(null, "Uberlancia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estRepo.saveAll(Arrays.asList(est1,est2));
		cidRepo.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "321321321", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("2252555","2525255"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "apto", "jadim", "8585858", cli1, c1);
		Endereco end2 = new Endereco(null, "av mattos", "105", "sala 800", "centro", "33352525", cli1, c1);
		
		cli1.getEndereco().addAll(Arrays.asList(end1,end2));
		clienteRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(end1,end2));
	}
}
