package com.merceariajoao.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produtos {

	
	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private long codigo;
	
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "data_validade")
	private String dataValidade;
	
	@Column(name = "lote")
	private String lote;
	


		

	}
		