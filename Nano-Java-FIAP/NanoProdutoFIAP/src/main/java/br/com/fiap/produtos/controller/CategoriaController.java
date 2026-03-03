package br.com.fiap.produtos.controller;

import br.com.fiap.produtos.model.dao.CategoriaDAO;
import br.com.fiap.produtos.model.dto.CategoriaTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaTO save(String nome) throws SQLException {
        categoriaDAO = new CategoriaDAO();
        return categoriaDAO.save(nome);
    }


    public ArrayList<CategoriaTO> findAll() throws SQLException {
        categoriaDAO = new CategoriaDAO();
        return categoriaDAO.findAll();
    }


    public CategoriaTO findById(Long idCategoria) throws SQLException {
        categoriaDAO = new CategoriaDAO();
        return categoriaDAO.findById(idCategoria);
    }

    public CategoriaTO findByNome(String nome) throws SQLException {
        categoriaDAO = new CategoriaDAO();
        return categoriaDAO.findByNome(nome);
    }
}
