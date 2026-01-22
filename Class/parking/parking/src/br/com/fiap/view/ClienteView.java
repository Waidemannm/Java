package br.com.fiap.view;

import br.com.fiap.controller.ClienteController;

import javax.swing.*;
import java.sql.SQLException;

public class ClienteView {
    public static void main(String[] args) {
        String placa, nomeCliente;
        int id, opcao;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        ClienteController clienteController = new ClienteController();
        do {
            try{
                opcao = JOptionPane.showOptionDialog(null, "Escolha um das opções abaixo para manipular um Carro", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao){
                    case 0:
                        nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                        placa = JOptionPane.showInputDialog("Digite a placa do carro:");
                        JOptionPane.showMessageDialog(null, clienteController.inserirCliente(nomeCliente, placa));
                        break;
                    case 1:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente"));
                        nomeCliente = JOptionPane.showInputDialog("Digite o NOVO nome do cliente:");
                        placa = JOptionPane.showInputDialog("Digite a NOVA placa do carro:");
                        JOptionPane.showMessageDialog(null, clienteController.alterarCliente(id,nomeCliente, placa));
                        break;
                    case 2:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente"));
                        JOptionPane.showMessageDialog(null, clienteController.excluirCliente(id));
                        break;
                    case 3:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do cliente"));
                        JOptionPane.showMessageDialog(null, clienteController.listarUmCliente(id));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!)", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }catch (ClassNotFoundException e) {
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
