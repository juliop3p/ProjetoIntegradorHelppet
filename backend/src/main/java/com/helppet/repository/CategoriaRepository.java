package com.helppet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helppet.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
	//secaoCategoria
	public List<CategoriaModel> findAllBySecaoCategoriaContainingIgnoreCase(String secaoCategoria);
	
	//subsecaoCategoria
	public List<CategoriaModel> findAllBySubSecaoCategoriaContainingIgnoreCase(String subSecaoCategoria);
	
	//animalCategoria
	public List<CategoriaModel> findAllByAnimalCategoriaContainingIgnoreCase(String animalCategoria);
 
}
