package com.helppet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column
	@NotNull
	private String nomeUsuario;

	@Column(unique = true)
	@NotNull
	@Email
	private String emailUsuario;

	@Column
	@NotNull
	private String senhaUsuario;

	@Column(unique = true)
	private String cpfUsuario;

	@Column
	private String telefoneUsuario;

	@Column
	private String enderecoUsuario;

	@Column
	private String dataNascimentoUsuario;

	@Column
	@NotNull
	private boolean admin;

	// Getters e Setters

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public String getDataNascimentoUsuario() {
		return dataNascimentoUsuario;
	}

	public void setDataNascimentoUsuario(String dataNascimentoUsuario) {
		this.dataNascimentoUsuario = dataNascimentoUsuario;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
