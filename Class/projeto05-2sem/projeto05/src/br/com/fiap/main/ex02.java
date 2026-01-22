package br.com.fiap.main;

import javax.swing.*;

public class ex02 {
    public static void main(String[] args) {
        try{
            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número (1-50)"));
            if (num1 < 1 || num1 > 50){
                throw new Exception("Número inválido (1-50)");
            }
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número inteiro"));
            JOptionPane.showMessageDialog(null, "Soma :" + (num1 + num2));
            JOptionPane.showMessageDialog(null, "Subtração :" + (num1 - num2));
            JOptionPane.showMessageDialog(null, "Multiplicação :" + (num1 * num2));
            JOptionPane.showMessageDialog(null, "Divisão :" + (num1 / num2));
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Erro formato numérico: " + e.getMessage());
        } catch (ArithmeticException e){
            JOptionPane.showMessageDialog(null, "Erro de divisão por zero: "+ e.getMessage());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage());
        } finally {
            JOptionPane.showMessageDialog(null, "Fim de Programa!");
        }

    }
}