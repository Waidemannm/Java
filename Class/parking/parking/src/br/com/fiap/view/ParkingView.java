package br.com.fiap.view;

import br.com.fiap.controller.CarroController;
import br.com.fiap.controller.ClienteController;

import javax.swing.*;
import java.sql.SQLException;

public class ParkingView {
    public static void main(String[] args) {
        String placa, cor, descricao, nova_cor, novaDescricao, nomeCliente;
        int opcaoPrincipal, opcaoSubMenu, id;
        String[] escolhaPrincipal = {"Cliente", "Carro"};
        String[] escolhaSubMenu = {"Inserir", "Alterar", "Excluir", "Listar"};
        do{
            try{
                opcaoPrincipal = JOptionPane.showOptionDialog(null, "Escolha um das opções abaixo para manipular um Objeto", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaPrincipal, escolhaPrincipal[0]);
                switch (opcaoPrincipal){
                    case 0:
                        do {
                            try {
                                ClienteController clienteController = new ClienteController();
                                opcaoSubMenu = JOptionPane.showOptionDialog(null, "Escolha um das opções abaixo para manipular um Cliente", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaSubMenu, escolhaSubMenu[0]);
                                switch (opcaoSubMenu){
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
                        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar em Clientes?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
                        JOptionPane.showMessageDialog(null, "Fim de execução de Clientes!", "Adeus", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 1:
                        CarroController carroController = new CarroController();
                        do {
                            try{
                                opcaoSubMenu = JOptionPane.showOptionDialog(null, "Escolha um das opções abaixo para manipular um Carro", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaSubMenu, escolhaSubMenu[0]);
                                switch (opcaoSubMenu){
                                    case 0:
                                        placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
                                        cor = JOptionPane.showInputDialog("Digite uma cor: ");
                                        descricao = JOptionPane.showInputDialog("Digite uma descrição: ");
                                        JOptionPane.showMessageDialog(null, carroController.inserirCarro(placa, cor, descricao));
                                        break;
                                    case 1:
                                        placa = JOptionPane.showInputDialog("Digite a placa do carro: ");
                                        nova_cor = JOptionPane.showInputDialog("Digite uma nova cor: ");
                                        novaDescricao = JOptionPane.showInputDialog("Digite uma nova descrição: ");
                                        JOptionPane.showMessageDialog(null, carroController.alterarCarro(placa, nova_cor, novaDescricao));
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
                                        JOptionPane.showMessageDialog(null, "Opção inválida!)", "Atenção", JOptionPane.WARNING_MESSAGE);
                                }
                            } catch (ClassNotFoundException e) {
                                JOptionPane.showMessageDialog(null, "Classe não encontrada " + e.getMessage());
                            } catch (SQLException e){
                                JOptionPane.showMessageDialog(null,"Erro de SQL " + e.getMessage());
                            } catch ( Exception e){
                                JOptionPane.showMessageDialog(null,"Erro " + e.getMessage());
                            }
                        }while (JOptionPane.showConfirmDialog(null, "Deseja continuar em Carros?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
                        JOptionPane.showMessageDialog(null, "Fim de execução de Carros!", "Adeus", JOptionPane.WARNING_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!)", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            } catch ( Exception e){
                JOptionPane.showMessageDialog(null,"Erro " + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim de programa. Até breve!", "Adeus", JOptionPane.WARNING_MESSAGE);
    }
}
