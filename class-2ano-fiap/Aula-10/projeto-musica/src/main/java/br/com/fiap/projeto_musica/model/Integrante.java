package br.com.fiap.projeto_musica.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "integrante")
public class Integrante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "fk_banda")
	private Banda banda;
	private String nome;
	@PastOrPresent(message = "Data de nascimento inválida")
	private LocalDate data_nascimento;
	private String funcao;

	public Integrante() {

	}

	public Integrante(Long id, Banda banda, String nome, LocalDate data_nascimento, String funcao) {
		super();
		this.id = id;
		this.banda = banda;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.funcao = funcao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

}
