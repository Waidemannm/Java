package br.com.fiap.produtos.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ProdutoTO {
    private String nome;
    private Long idProduto;
    private BigDecimal preco;
    private LocalDate dataCadastro;
    private String descricao;
    private Long idCategoria;

    public ProdutoTO() {
    }

    public ProdutoTO(String nome, Long idProduto, BigDecimal preco, LocalDate dataCadastro, String descricao, Long idCategoria) {
        this.nome = nome;
        this.idProduto = idProduto;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        ProdutoTO produto = (ProdutoTO) object;
        return Objects.equals(idProduto, produto.idProduto);
    }

    @Override
    public String toString(){
        return nome.toUpperCase();
    }

    @Override
    public int hashCode(){
        return Objects.hash(idProduto);
    }
}
