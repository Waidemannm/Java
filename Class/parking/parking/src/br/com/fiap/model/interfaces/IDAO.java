package br.com.fiap.model.interfaces;

import java.sql.SQLException;

public interface IDAO {
    public String inserir(Object object) throws SQLException;
    public String alterar(Object object) throws SQLException;
    public String excluir(Object object) throws SQLException;
    public String listarUm(Object object) throws SQLException;
}
