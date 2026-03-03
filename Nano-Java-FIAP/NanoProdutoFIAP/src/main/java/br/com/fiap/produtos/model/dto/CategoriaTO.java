package br.com.fiap.produtos.model.dto;

import java.util.Objects;

public class CategoriaTO {
    private Long idCategoria;
    private String nome;

    public CategoriaTO(){

    }

    public CategoriaTO(String nome) {
        this.nome = nome;
    }

    public CategoriaTO(Long id, String nome) {
        this.idCategoria = id;
        this.nome = nome;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        CategoriaTO categoria = (CategoriaTO) object;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public String toString(){
        return nome.toUpperCase();
    }

    @Override
    public int hashCode(){
        return Objects.hash(idCategoria);
    }

}

