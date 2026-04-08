package br.com.fiap.projeto_musica.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "banda")
public class Banda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;
	private LocalDate data_fundacao;
	private String pais_origem;
	private Boolean ativa;

	public Banda() {

	}

	public Banda(Long id, String nome, LocalDate data_fundacao, String pais_origem, Boolean ativa) {
		super();
		this.id = id;
		this.nome = nome;
		this.data_fundacao = data_fundacao;
		this.pais_origem = pais_origem;
		this.ativa = ativa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_fundacao() {
		return data_fundacao;
	}

	public void setData_fundacao(LocalDate data_fundacao) {
		this.data_fundacao = data_fundacao;
	}

	public String getPais_origem() {
		return pais_origem;
	}

	public void setPais_origem(String pais_origem) {
		this.pais_origem = pais_origem;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}

}
