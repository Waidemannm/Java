package br.com.fiap.main;

import br.com.fiap.bean.FolhaDePagamento;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FolhaDePagamento pagamento = new FolhaDePagamento();
        pagamento.salarioBruto = 10000.00;
        pagamento.numeroDeDependentes = 3;
        pagamento.valorPlanoDeSaude = 2000.00;
        pagamento.descondoINSS = 10;
        String mensagem = String.format("O sálario bruto é %.2f", pagamento.calcularSalarioLiquido());
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
