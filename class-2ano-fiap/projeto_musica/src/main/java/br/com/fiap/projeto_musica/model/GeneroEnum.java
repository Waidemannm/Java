package br.com.fiap.projeto_musica.model;

public enum GeneroEnum {

    ROCK("Rock"), SERTANEJO("Sertanejo"), GOSPEL("Gospel"), METAL("Metal"), POP("Pop");

    private String descricao;

    GeneroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
