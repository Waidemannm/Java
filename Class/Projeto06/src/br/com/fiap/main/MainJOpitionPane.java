package br.com.fiap.main;

import br.com.fiap.bean.FolhaDePagamento;

import javax.swing.*;

public class MainJOpitionPane {
    public static void main(String[] args) {
        FolhaDePagamento folha = new FolhaDePagamento();
        String auxiliar;
        try {
            auxiliar = JOptionPane.showInputDialog("Digite seu salario bruto: ");
            folha.salarioBruto = Double.parseDouble(auxiliar);
            auxiliar = JOptionPane.showInputDialog("Digite a quantidade de dependentes:  ");
            folha.numeroDeDependentes = Integer.parseInt(auxiliar);
            auxiliar = JOptionPane.showInputDialog("Digite o valor do seu plano de saude: ");
            folha.valorPlanoDeSaude = Double.parseDouble(auxiliar);
            auxiliar = JOptionPane.showInputDialog("Digite o desconto do INSS: ");
            folha.descontoINSS = Double.parseDouble(auxiliar);
            String mensagem = String.format("O seu salario bruto é: %.2f\nA quantidade de dependentes são: %d" +
                    "\nO valor do palno de saude é: %.2f\nO desconto do INSS é: %.2f\nSeu salario liquido é: %.2f",
                    folha.salarioBruto, folha.numeroDeDependentes, folha.valorPlanoDeSaude, folha.descontoINSS,
                    folha.calcularSalarioLiquido());
            JOptionPane.showMessageDialog(null, mensagem);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Forma numerica errada!");
        }
    }
}
