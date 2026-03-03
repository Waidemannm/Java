package br.com.fiap.produtos.view;

import br.com.fiap.produtos.controller.CategoriaController;
import br.com.fiap.produtos.controller.ProdutoController;
import br.com.fiap.produtos.model.dto.CategoriaTO;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class LojaView {
    public static void main(String[] args) {
        String[] escolhaPrincipal = {"Categoria", "Produto"};
        String[] escolhaSecundaria = {"Inserir","Listar todos","Procurar pelo nome","Procurar pelo id"};
        int opcaoPrincipal;
        try{
            do{
                opcaoPrincipal = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular uma Categoria ou um Produto", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaPrincipal, escolhaPrincipal[0]);
                switch (opcaoPrincipal) {
                    case 0:
                        int opcaoSecundaria;
                        CategoriaController categoriaController = new CategoriaController();
                        CategoriaTO categoriaTO = new CategoriaTO();
                        String nome, auxId;
                        Long id;
                        ArrayList<CategoriaTO> categorias = new ArrayList<>();
                        try{
                            opcaoSecundaria = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular uma Categoria", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaSecundaria, escolhaSecundaria[0]);
                            switch (opcaoSecundaria){
                                case 0:
                                    nome = JOptionPane.showInputDialog("Digite o nome da categoria: ");
                                    categoriaController.save(nome);
                                    break;
                                case 1:
                                    JOptionPane.showMessageDialog(null, categoriaController.findAll());
                                    break;
                                case 2:
                                    nome = JOptionPane.showInputDialog("Digite o nome da categoria: ");
                                    JOptionPane.showMessageDialog(null, categoriaController.findByNome(nome));
                                    break;
                                case 3:
                                    auxId = JOptionPane.showInputDialog("Digite o id do produto:");
                                    id = Long.parseLong(auxId);
                                    JOptionPane.showMessageDialog(null, categoriaController.findById(id));
                                    break;

                            }
                        }catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());;
                        }
                        break;
                    case 1:
                        int opcaoTerciaria;
                        ProdutoController produtoController = new ProdutoController();
                        String nomeProduto, descricao, auxPreco, auxIdProduto;
                        BigDecimal preco;
                        LocalDate dataCadastro;
                        Long idProduto, idCategoria;
                        try{
                            opcaoTerciaria = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Produto", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolhaSecundaria, escolhaSecundaria[0]);
                            switch (opcaoTerciaria){
                                case 0:
                                    idCategoria = Long.getLong(JOptionPane.showInputDialog("Digite o id da categoria: "));
                                    nomeProduto = JOptionPane.showInputDialog("Digite o nome da categoria: ");
                                    auxPreco = JOptionPane.showInputDialog("Digite o preço do produto:");
                                    preco = new BigDecimal(auxPreco);
                                    dataCadastro = LocalDate.now();
                                    descricao = JOptionPane.showInputDialog("Digite uma descrição: ");
                                    produtoController.save(idCategoria, nomeProduto, preco, dataCadastro, descricao);
                                    break;
                                case 1:
                                    JOptionPane.showMessageDialog(null, produtoController.findAll());
                                    break;
                                case 2:
                                    nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto: ");
                                    JOptionPane.showMessageDialog(null, produtoController.findByNome(nomeProduto));
                                    break;
                                case 3:
                                    auxIdProduto = JOptionPane.showInputDialog("Digite o id do produto:");
                                    idProduto = Long.parseLong(auxIdProduto);
                                    JOptionPane.showMessageDialog(null, produtoController.findById(idProduto));
                                    break;

                            }
                        }catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());;
                        }
                        break;
                }
            } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
            JOptionPane.showMessageDialog(null, "Fim de Programa");
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());;
        }
    }
}