package com.rafa.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafa.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository2 extends JpaRepository<Endereco, Integer> {

}
