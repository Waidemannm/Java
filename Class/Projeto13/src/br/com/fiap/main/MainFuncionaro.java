package br.com.fiap.main;

import br.com.fiap.bean.Funcionario;
import br.com.fiap.bean.Vendedor;
import br.com.fiap.bean.VigiaNoturno;
import javax.swing.*;

public class MainFuncionaro {
    public static void main(String[] args) {
        String auxiliar, nome, escolha = "Sim";
        float valorHoraTrabalho, adicionalNoturno, comissao, salario;
        int opcao;
        while (escolha.equalsIgnoreCase("Sim")){
            try {
                auxiliar = JOptionPane.showInputDialog("Qual o tipo de funcionário: \n1.Funcionário \n2.Vigia Noturno \n3.Vendedor");
                opcao = Integer.parseInt(auxiliar);
                switch (opcao){
                    case 1:
                        nome = JOptionPane.showInputDialog("Digite o nome do funcionáro: ");
                        auxiliar = JOptionPane.showInputDialog("Digite o valor da hora trabalhada: ");
                        valorHoraTrabalho = Float.parseFloat(auxiliar);
                        Funcionario func = new Funcionario(valorHoraTrabalho, nome);
                        salario = func.calcularSalario();
                        JOptionPane.showMessageDialog(null, String.format("Funcionário: %s \nSálario: %.2f", nome, salario));
                        break;
                    case 2:
                        nome = JOptionPane.showInputDialog("Digite o nome do funcionáro: ");
                        auxiliar = JOptionPane.showInputDialog("Digite o valor da hora trabalhada: ");
                        valorHoraTrabalho = Float.parseFloat(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite o valor do adiconal noturno: ");
                        adicionalNoturno = Float.parseFloat(auxiliar);
                        VigiaNoturno vig = new VigiaNoturno(valorHoraTrabalho, nome, adicionalNoturno);
                        salario = vig.calcularSalario();
                        JOptionPane.showMessageDialog(null, String.format("Funcionário: %s \nAdicional Noturno: %.2f \nSálario: %.2f", nome, adicionalNoturno, salario));
                        break;
                    case 3:
                        nome = JOptionPane.showInputDialog("Digite o nome do funcionáro: ");
                        auxiliar = JOptionPane.showInputDialog("Digite o valor da hora trabalhada: ");
                        valorHoraTrabalho = Float.parseFloat(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite o valor da comissão: ");
                        comissao = Float.parseFloat(auxiliar);
                        Vendedor vend = new Vendedor(valorHoraTrabalho, nome, comissao);
                        salario = vend.calcularSalario();
                        JOptionPane.showMessageDialog(null, String.format("Funcionário: %s \nComissão: %.2f \nSálario: %.2f", nome, comissao, salario));
                        break;
                    default:
                        throw new Exception("Digite uma das opções possivéis!");
                }
                escolha = JOptionPane.showInputDialog("Deseja Continuar?");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Obrigado, Volte Sempre!");
    }
}
