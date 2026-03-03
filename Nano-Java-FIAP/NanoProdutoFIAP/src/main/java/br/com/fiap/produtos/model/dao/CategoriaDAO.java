package br.com.fiap.produtos.model.dao;

import br.com.fiap.produtos.model.dto.CategoriaTO;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO  {

    public CategoriaTO save(String nome) throws SQLException {
        CategoriaTO categoriaTO = new CategoriaTO();
        String sql = "INSERT INTO T_NANO_CATEGORIA(NM_CATEGORIA) values(?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);) {
            ps.setString(1, nome);
            if (ps.executeUpdate() > 0) {
                return categoriaTO;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao registrar.", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível registrar a categoria: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }


    public ArrayList<CategoriaTO> findAll() throws SQLException {
        ArrayList<CategoriaTO> categorias = new ArrayList<>();
        String sql = "SELECT * FROM T_NANO_CATEGORIA";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                CategoriaTO categoria = new CategoriaTO();
                categoria.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                categoria.setNome(rs.getString("NM_CATEGORIA"));
                categorias.add(categoria);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todas categorias: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return categorias;
    }


    public CategoriaTO findById(Long id) throws SQLException {
        CategoriaTO categoriaTO = new CategoriaTO();
        String sql = "SELECT * FROM T_NANO_CATEGORIA WHERE ID_CATEGORIA = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoriaTO.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                categoriaTO.setNome(rs.getString("NM_CATEGORIA"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a categoria: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return categoriaTO;
    }

    public CategoriaTO findByNome(String nome) throws SQLException {
        CategoriaTO categoriaTO = new CategoriaTO();
        String sql = "SELECT * FROM T_NANO_CATEGORIA WHERE NM_CATEGORIA = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                categoriaTO.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                categoriaTO.setNome(rs.getString("NM_CATEGORIA"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a categoria: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return categoriaTO;
    }
}
