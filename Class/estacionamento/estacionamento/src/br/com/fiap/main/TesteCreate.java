package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;

import java.sql.Connection;

public class TesteCreate {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        Carro carro = new Carro();
        carro.setPlaca("EFE7338");
        carro.setCor("VERMELHO");
        carro.setDescricao("GT3");
        CarroDAO carroDAO = new CarroDAO(con);
        System.out.println(carroDAO.inserir(carro));
        ConnectionFactory.fecharConexao(con);
    }
}
