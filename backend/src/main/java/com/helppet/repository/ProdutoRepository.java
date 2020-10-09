package com.helppet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helppet.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	public List<ProdutoModel> findAllByNomeProdutoContainingIgnoreCase(String nomeProduto);

}