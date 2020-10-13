package com.helppet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helppet.model.CategoriaModel;
import com.helppet.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	public CategoriaRepository repository;

	//MÉTODOS CRUD
	// findAll - Retorna todos os Dados.
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// findById - Retorna o dado pelo ID.
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> findById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	// findAllBySecaoCategoria - Retorna pelo nome.
	@GetMapping("/secaocategoria/{secaocategoria}")
	public ResponseEntity<List<CategoriaModel>> findAllBySecaoCategoria(@PathVariable String secaocategoria) {
		return ResponseEntity.ok(repository.findAllBySecaoCategoriaContainingIgnoreCase(secaocategoria));
	}

	// findAllBySubSecaoCategoria - Retorna pelo nome.
	@GetMapping("/subsecaocategoria/{subsecaocategoria}")
	public ResponseEntity<List<CategoriaModel>> findAllBySubSecaoCategoria(@PathVariable String subsecaocategoria) {
		return ResponseEntity.ok(repository.findAllBySubSecaoCategoriaContainingIgnoreCase(subsecaocategoria));
	}

	// findAllByAnimalCategoria - Retorna pelo nome.
	@GetMapping("/animalcategoria/{animalcategoria}")
	public ResponseEntity<List<CategoriaModel>> findAllByAnimalCategoria(@PathVariable String animalcategoria) {
		return ResponseEntity.ok(repository.findAllByAnimalCategoriaContainingIgnoreCase(animalcategoria));
	}

	// post - Cria um dado.
	@PostMapping
	public ResponseEntity<CategoriaModel> post(@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	// put - Atualiza o dado.
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaModel> put(@PathVariable Long id, @RequestBody CategoriaModel categoria) {
		categoria.setIdCategoria(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}

	// delete - Deleta um dado.
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
