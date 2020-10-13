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

import com.helppet.model.UsuarioModel;
import com.helppet.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	//MÉTODOS CRUD
	// findAll - Retorna todos os Dados.
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// findById - Retorna o dado pelo ID.
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> findByIdUsuario(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	// post - Cria um dado.
	@PostMapping
	public ResponseEntity<UsuarioModel> post(@RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}

	// put - Atualiza o dado.
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioModel> put(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
		usuario.setIdUsuario(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}

	// delete - Deleta um dado.
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
