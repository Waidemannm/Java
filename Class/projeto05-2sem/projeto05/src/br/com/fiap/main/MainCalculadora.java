package br.com.fiap.main;

import br.com.fiap.bean.Calculadora;

import javax.swing.*;

public class MainCalculadora {
    public static void main(String[] args) {
        int operacao;
        float num1, num2;
        Calculadora calculadora = new Calculadora();
        do {
            try{
                num1 = Float.parseFloat(JOptionPane.showInputDialog("Digite um número"));
                num2 = Float.parseFloat(JOptionPane.showInputDialog("Digite outro número"));
                calculadora.setNumero1(num1);
                calculadora.setNumer2(num2);
                try{
                    operacao = Integer.parseInt(JOptionPane.showInputDialog("Escolha um número para operção desejada \n(1)Adição \n(2)Subtração \n(3)Multiplicação \n(4)Divisão"));
                    switch (operacao){
                        case 1:
                            JOptionPane.showMessageDialog(null, "O resultado da soma  é: " + calculadora.adicao(), "Adição", JOptionPane.INFORMATION_MESSAGE);
                            calculadora.adicao();
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "O resultado da subtração  é: " + calculadora.subtracao(), "Subtração", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "O resultado da multiplicação  é: " + calculadora.multiplicacao(), "Multiplicação", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "O resultado da divisão  é: " + calculadora.divisao(), "Divisão", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                          throw new Exception("Opção inválida");
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Erro formato numérico: " + e.getMessage());
            } finally {
                JOptionPane.showMessageDialog(null, "Fim da operação!", "Infromação ", JOptionPane.INFORMATION_MESSAGE);
            }
        }while (JOptionPane.showConfirmDialog(null, "deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa!");
    }
}
