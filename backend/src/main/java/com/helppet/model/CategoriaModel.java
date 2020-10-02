package com.helppet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_categorias")
public class CategoriaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;

	@Column
	@NotNull
	private String secaoCategoria;

	@Column
	@NotNull
	private String subSecaoCategoria;

	@Column
	@NotNull
	private String animalCategoria;

	// Getters e Setters

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getSecaoCategoria() {
		return secaoCategoria;
	}

	public void setSecaoCategoria(String secaoCategoria) {
		this.secaoCategoria = secaoCategoria;
	}

	public String getSubSecaoCategoria() {
		return subSecaoCategoria;
	}

	public void setSubSecaoCategoria(String subSecaoCategoria) {
		this.subSecaoCategoria = subSecaoCategoria;
	}

	public String getAnimalCategoria() {
		return animalCategoria;
	}

	public void setAnimalCategoria(String animalCategoria) {
		this.animalCategoria = animalCategoria;
	}

}
