package br.com.fiap.revisao;

public enum DietaEnum {

	CARNIVORO("Carnívoro"), HERBIVORO("Herbívoro"), ONIVORO("Onívoro");

	private String descricao;

	DietaEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
