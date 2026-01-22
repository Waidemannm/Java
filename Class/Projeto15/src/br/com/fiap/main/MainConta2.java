package br.com.fiap.main;

import br.com.fiap.bean.ContaEspecial;

import javax.swing.*;

public class MainConta2 {
    public static void main(String[] args) {
        String auxiliar, escolha ="Sim";
        float valor, saldo, limite;
        int numConta, opcao;
         while (escolha.equalsIgnoreCase("Sim")){
             try{
                 auxiliar = JOptionPane.showInputDialog("Digite o número da conta");
                 numConta = Integer.parseInt(auxiliar);
                 auxiliar = JOptionPane.showInputDialog("Digite o saldo da conta:");
                 saldo = Float.parseFloat(auxiliar);
                 auxiliar = JOptionPane.showInputDialog("Digite o limite da conta:");
                 limite = Float.parseFloat(auxiliar);
                 ContaEspecial ce = new ContaEspecial();
                 auxiliar = JOptionPane.showInputDialog("Digite a opção desejada \n1.Sacar \n2.Depositar");
                 opcao = Integer.parseInt(auxiliar);
                 ce.setNumConta(numConta);
                 ce.setSaldo(saldo);
                 ce.setLimite(limite);
                 switch (opcao){
                     case 1:
                         auxiliar = JOptionPane.showInputDialog("Digite o valor do saque:");
                         valor = Float.parseFloat(auxiliar);
                         JOptionPane.showMessageDialog(null, String.format("Dados da conta \nNúmero da conta: %d \nLimite da conta: %.2f \nSalo atual: R$ %.2f", ce.getNumConta(), ce.getLimite(), ce.sacar(valor)));
                         break;
                     case 2:
                         auxiliar = JOptionPane.showInputDialog("Digite o valor do depósito:");
                         valor = Float.parseFloat(auxiliar);
                         JOptionPane.showMessageDialog(null, String.format("Dados da conta \nNúmero da conta: %d \nLimite da conta: %.2f \nSalo atual: R$ %.2f", ce.getNumConta(), ce.getLimite(),ce.sacar(valor)));
                         break;
                     default:
                         JOptionPane.showMessageDialog(null, "Opção não identificada!");
                 }
                 escolha  = JOptionPane.showInputDialog("Deseja continuar?");
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         }
        JOptionPane.showMessageDialog(null, "Programa encerrado, obrigado!");
    }
}
