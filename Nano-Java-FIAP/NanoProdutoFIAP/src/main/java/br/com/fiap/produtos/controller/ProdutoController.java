package br.com.fiap.produtos.controller;



import br.com.fiap.produtos.model.dao.ProdutoDAO;
import br.com.fiap.produtos.model.dto.ProdutoTO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoTO save(Long idCategoria, String nome, BigDecimal preco, LocalDate dataCadastro, String descricao) throws SQLException {
        produtoDAO = new ProdutoDAO();
        return produtoDAO.save(idCategoria, nome, preco, dataCadastro, descricao);
    }


    public ArrayList<ProdutoTO> findAll() throws SQLException {
        produtoDAO = new ProdutoDAO();
        return produtoDAO.findAll();
    }


    public ProdutoTO findById(Long idProduto) throws SQLException {
        produtoDAO = new ProdutoDAO();
        return produtoDAO.findById(idProduto);
    }

    public ProdutoTO findByNome(String nome) throws SQLException {
        produtoDAO = new ProdutoDAO();
        return produtoDAO.findByNome(nome);
    }
}
