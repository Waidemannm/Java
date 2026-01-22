package br.com.fiap.view;

import br.com.fiap.controller.CarroController;

import javax.swing.*;
import java.sql.SQLException;

public class CarroView {
    public static void main(String[] args) {
        String placa, cor, descricao, nova_cor, nova_descricao;
        int opcao;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        CarroController carroController = new CarroController();
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha um das opções abaixo para manipular um Carro", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao){
                    case 0:
                        placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
                        cor = JOptionPane.showInputDialog("Digite uma cor: ");
                        descricao = JOptionPane.showInputDialog("Digite uma descrição: ");
                        JOptionPane.showMessageDialog(null, carroController.inserirCarro(placa, cor, descricao));
                        break;
                    case 1:
                        placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
                        nova_cor = JOptionPane.showInputDialog("Digite uma nova cor: ");
                        nova_descricao = JOptionPane.showInputDialog("Digite uma nova descrição: ");
                        JOptionPane.showMessageDialog(null, carroController.alterarCarro(placa, nova_cor, nova_descricao));
                        break;
                    case 2:
                        placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
                        JOptionPane.showMessageDialog(null, carroController.excluirCarro(placa));
                        break;
                    case 3:
                        placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
                        JOptionPane.showMessageDialog(null, carroController.listarUmCarro(placa));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Classe não encontrada " + e.getMessage());
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null,"Erro de SQL " + e.getMessage());
            } catch ( Exception e){
                JOptionPane.showMessageDialog(null,"Erro " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de programa. Até breve!", "Adeus", JOptionPane.WARNING_MESSAGE);
    }
}
