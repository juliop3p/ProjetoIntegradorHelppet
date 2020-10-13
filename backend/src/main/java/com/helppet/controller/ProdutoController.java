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

import com.helppet.model.ProdutoModel;
import com.helppet.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	

	@Autowired
	private ProdutoRepository repository;

	//MÉTODOS CRUD
	// findAll - Retorna todos os Dados.
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// findById - Retorna o dado pelo ID.
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> findById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	// findByNomeProduto - Retorna pelo nome.
	@GetMapping("produto/{produto}")
	public ResponseEntity<List<ProdutoModel>> findByNomeProduto(@PathVariable String produto) {
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(produto));
	}

	// post - Cria um dado.
	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	// put - Atualiza o dado.
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoModel> put(@PathVariable Long id, @RequestBody ProdutoModel produto) {
		produto.setIdProduto(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

	// delete - Deleta um dado.
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
