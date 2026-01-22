package br.com.fiap.main;

import br.com.fiap.bean.Pessoa;

import javax.swing.*;
import java.io.IOException;

public class UsaPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        String codigo, nome, email, path;
        int escolha;
        do {
            try{
                escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite a operação desejada \n(1)Cadastrar\n(2)Consultar"));
                path = JOptionPane.showInputDialog("Digite o caminho da pasta");
                switch (escolha){
                    case 1:
                        codigo = JOptionPane.showInputDialog("Digite o código");
                        nome = JOptionPane.showInputDialog("Digite seu nome");
                        email = JOptionPane.showInputDialog("Informe se email");
                        pessoa.setCodigo(codigo);
                        pessoa.setNome(nome);
                        pessoa.setEmail(email);
                        JOptionPane.showMessageDialog(null, pessoa.gravar(path));
                        break;
                    case 2:
                        codigo = JOptionPane.showInputDialog("Digite o código");
                        pessoa.setCodigo(codigo);
                        pessoa = pessoa.ler(path);
                        if (pessoa == null){
                            JOptionPane.showMessageDialog(null, "Caminho e/ou código inexistente");
                        }else {
                        JOptionPane.showMessageDialog(null, "Exibindo dados \nAquivo: " +path + "/" + pessoa.getCodigo() + ".txt" + "\nCódigo: " + pessoa.getCodigo() + "\nNome: " + pessoa.getNome() + "\nEmail: " + pessoa.getEmail() + "\nCaminho: "+ path);
                        }
                        break;
                    default:
                        throw new Exception("Opção inválida");
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Erro formato numérico: " + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Erro de entrada ou saída de arquivo" + e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            }



        }while (JOptionPane.showConfirmDialog(null, "deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa", "FIM!",JOptionPane.INFORMATION_MESSAGE);
    }
}
