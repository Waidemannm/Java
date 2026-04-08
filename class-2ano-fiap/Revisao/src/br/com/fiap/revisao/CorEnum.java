package br.com.fiap.revisao;

public enum CorEnum {

	MARROM("Marrom"), BRANCO("Branca"), PRETO("Preta"), 
	RAJADO("Rajada"), CARAMELO("Caramelo");

	private String descricao;
	
	CorEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
