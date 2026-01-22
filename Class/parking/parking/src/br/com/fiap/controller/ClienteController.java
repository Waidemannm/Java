package br.com.fiap.controller;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.fiap.dto.Cliente;

public class ClienteController {
    public String inserirCliente(String nomeCliente, String placa) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con= ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        cliente.setNomeCliente(nomeCliente);
        cliente.setPlaca(placa);
        resultado = clienteDAO.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarCliente(int id, String nomeCleinte, String placa) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con= ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        cliente.setIdCliente(id);
        cliente.setNomeCliente(nomeCleinte);
        cliente.setPlaca(placa);
        resultado = clienteDAO.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirCliente(int id) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con= ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        cliente.setIdCliente(id);
        resultado = clienteDAO.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarUmCliente(int id) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con= ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        cliente.setIdCliente(id);
        resultado = clienteDAO.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
