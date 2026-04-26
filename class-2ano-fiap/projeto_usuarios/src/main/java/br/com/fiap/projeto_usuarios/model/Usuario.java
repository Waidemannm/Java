package br.com.fiap.projeto_usuarios.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@EmbeddedId
	private ChaveComposta chaveComposta;
	private String senha;
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	@ManyToOne
	@JoinColumn(name = "fk_pessoa")
	private Pessoa pessoa;

	public Usuario() {

	}

	public Usuario(ChaveComposta chaveComposta, String senha, StatusEnum status, Pessoa pessoa) {
		super();
		this.chaveComposta = chaveComposta;
		this.senha = senha;
		this.status = status;
		this.pessoa = pessoa;
	}

	public ChaveComposta getChaveComposta() {
		return chaveComposta;
	}

	public void setChaveComposta(ChaveComposta chaveComposta) {
		this.chaveComposta = chaveComposta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
