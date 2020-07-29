package com.merceariajoao.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.merceariajoao.cadastro.model.Produtos;
import com.merceariajoao.cadastro.repository.ProdutosRepository;
@RestController
@RequestMapping("/api")
public class ProdutosController {

		
		@Autowired
		private ProdutosRepository produtosRepository;
	
		@GetMapping("/buscarprodutos")
		public List<Produtos> listarProdutos(){
			return produtosRepository.findAll();

	}

		@PostMapping("/adicionarprodutos")
		@ResponseStatus(HttpStatus.CREATED)
		public Produtos adicionarProdutos(@RequestBody Produtos produtos) {
			return produtosRepository.save(produtos);
		}
		
		
		@PutMapping("/atualizarprodutos/{produtosId}")
		public ResponseEntity<Produtos> atualizar(@PathVariable long produtosId,
				@RequestBody Produtos produtos){
		if(!produtosRepository.existsById(produtosId)) {
				return ResponseEntity.notFound().build();
			}
			produtos.setCodigo(produtosId);
			produtos = produtosRepository.save(produtos);
			return ResponseEntity.ok(produtos);
			
		}
		
		@DeleteMapping("/deletarprodutos/{produtosId}")
		public ResponseEntity<Void> remover(@PathVariable long produtosId){
			if(!produtosRepository.existsById(produtosId)) {
					return ResponseEntity.notFound().build();
			}
			produtosRepository.deleteById(produtosId);
			return ResponseEntity.noContent().build();
		}
		
		
}