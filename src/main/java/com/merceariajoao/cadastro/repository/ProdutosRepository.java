package com.merceariajoao.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merceariajoao.cadastro.model.Produtos;


@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
	       

}
