package br.com.fiap.projeto_usuarios.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChaveComposta implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String rm;

	public ChaveComposta() {

	}

	public ChaveComposta(Integer id, String rm) {
		super();
		this.id = id;
		this.rm = rm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

}
