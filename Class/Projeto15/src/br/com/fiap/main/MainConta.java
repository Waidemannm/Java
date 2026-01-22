package br.com.fiap.main;

import br.com.fiap.bean.ContaPoupanca;

import javax.swing.*;

public class MainConta {
    public static void main(String[] args) {
        String auxiliar, escolha = "sim";
        int numConta, opcao;
        float valor, saldo;
        while(escolha.equalsIgnoreCase("Sim")){
            try{
                auxiliar = JOptionPane.showInputDialog("Digite o número da conta");
                numConta = Integer.parseInt(auxiliar);
                auxiliar = JOptionPane.showInputDialog("Digite o saldo da conta:");
                saldo = Float.parseFloat(auxiliar);
                ContaPoupanca cp = new ContaPoupanca();
                cp.setNumConta(numConta);
                cp.setSaldo(saldo);
                auxiliar = JOptionPane.showInputDialog("Digite a opção desejada \n1.Sacar \n2.Depositar");
                opcao = Integer.parseInt(auxiliar);
                switch (opcao){
                    case 1:
                        auxiliar = JOptionPane.showInputDialog("Digite o valor do saque:");
                        valor = Float.parseFloat(auxiliar);
                        JOptionPane.showMessageDialog(null, String.format("Dados da conta \nNúmero da conta: %d \nSalo atual: R$ %.2f", cp.getNumConta(), cp.sacar(valor)));
                        break;
                    case 2:
                        auxiliar = JOptionPane.showInputDialog("Digite o valor do depósito:");
                        valor = Float.parseFloat(auxiliar);
                        JOptionPane.showMessageDialog(null, String.format("Dados da conta \nNúmero da conta: %d \nSalo atual: R$ %.2f", cp.getNumConta(), cp.sacar(valor)));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção não identificada!");
                }
                escolha = JOptionPane.showInputDialog("Deseja continuar?");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Fim de Programa");
    }
}
