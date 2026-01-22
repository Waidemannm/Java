package br.com.fiap.model.dao;
import br.com.fiap.model.interfaces.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.dto.Cliente;

import javax.swing.*;

public class ClienteDAO implements IDAO {
    private Connection con;
    private Cliente cliente;

    public ClienteDAO(Connection con){this.con = con;}

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object) throws SQLException{
        cliente = (Cliente) object;
        String sql = "insert into ddd_cliente(nome_cliente,placa) values(?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Resgitrado com sucesso.";
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao registrar.", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Falha";
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível registrar o carro: " ,"Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro de SQL: " + e.getMessage();
        }
    }
    public String alterar(Object object) throws SQLException{
        cliente = (Cliente) object;
        String sql = "update ddd_cliente set nome_cliente = ?,placa = ? where id_cliente = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getPlaca());
            ps.setInt(3, cliente.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao alterar.", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Falha";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar", "Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro de SQL: " + e.getMessage();
        }
    }
    public String excluir(Object object) throws SQLException{
        cliente = (Cliente) object;
        String sql = "delete from ddd_cliente where id_cliente = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setInt(1, cliente.getIdCliente());
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso.";
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
                return "Falha";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:", "Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro de SQL: " + e.getMessage();
        }
    }
    public String listarUm(Object object) throws SQLException{
        cliente = (Cliente) object;
        String sql = "select * from ddd_cliente where id_cliente = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return String.format("Id cliente: %s \nNome: %s \nPlaca: %s", rs.getInt("id_cliente"), rs.getString("nome_cliente"), rs.getString("placa"));
            } else {
                return "Registro não encontrado";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
