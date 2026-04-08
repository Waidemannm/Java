package br.com.fiap.revisao;

public enum ClasseEnum {
	
	MAMIFERO("Mamífero"), ANFIBIO("Anfíbio"), REPTIL("Réptil"), 
	PEIXE("Peixe"), AVE("Ave");
	
private String descricao;
	
	ClasseEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
