package br.com.fiap.produtos.model.dao;
import br.com.fiap.produtos.model.dto.ProdutoTO;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProdutoDAO {

    public ProdutoTO save(Long idCategoria, String nome, BigDecimal preco, LocalDate dataCadastro, String descricao) throws SQLException {
        ProdutoTO produtoTO = new ProdutoTO();
        String sql = "INSERT INTO T_NANO_PRODUTO(ID_CATEGORIA, NM_PRODUTO, VL_PRECO, DT_CADASTRO, DS_PRODUTO) values(?,?,?,?,?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);) {
            ps.setLong(1, idCategoria);
            ps.setString(2, nome);
            ps.setBigDecimal(3, preco);
            ps.setDate(4, Date.valueOf(dataCadastro));
            ps.setString(5, descricao);
            if (ps.executeUpdate() > 0) {
                return produtoTO;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao registrar.", "Erro", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível registrar o produto: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }


    public ArrayList<ProdutoTO> findAll() throws SQLException {
        ArrayList<ProdutoTO> produtos = new ArrayList<>();
        String sql = "SELECT * FROM T_NANO_PRODUTO";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ProdutoTO produto = new ProdutoTO();
                produto.setIdProduto(rs.getLong("ID_PRODUTO"));
                produto.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                produto.setNome(rs.getString("NM_PRODUTO"));
                produto.setPreco(rs.getBigDecimal("VL_PRECO"));
                produto.setDataCadastro(rs.getDate("DT_CADASTRO").toLocalDate());
                produto.setDescricao(rs.getString("DS_PRODUTO"));
                produtos.add(produto);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível buscar todos os produtos: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return produtos;
    }


    public ProdutoTO findById(Long id) throws SQLException {
        ProdutoTO produto = new ProdutoTO();
        String sql = "SELECT * FROM T_NANO_PRODUTO WHERE ID_PRODUTO = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto.setIdProduto(rs.getLong("ID_PRODUTO"));
                produto.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                produto.setNome(rs.getString("NM_PRODUTO"));
                produto.setPreco(rs.getBigDecimal("VL_PRECO"));
                produto.setDataCadastro(rs.getDate("DT_CADASTRO").toLocalDate());
                produto.setDescricao(rs.getString("DS_PRODUTO"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a produto: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return produto;
    }

    public ProdutoTO findByNome(String nome) throws SQLException {
        ProdutoTO produto = new ProdutoTO();
        String sql = "SELECT * FROM T_NANO_PRODUTO WHERE NM_PRODUTO = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql);) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto.setIdProduto(rs.getLong("ID_PRODUTO"));
                produto.setIdCategoria(rs.getLong("ID_CATEGORIA"));
                produto.setNome(rs.getString("NM_PRODUTO"));
                produto.setPreco(rs.getBigDecimal("VL_PRECO"));
                produto.setDataCadastro(rs.getDate("DT_CADASTRO").toLocalDate());
                produto.setDescricao(rs.getString("DS_PRODUTO"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o produto: " ,"Erro", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.closeConnection();
        }
        return produto;
    }
}
