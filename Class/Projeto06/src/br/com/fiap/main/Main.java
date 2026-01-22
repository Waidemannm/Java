package br.com.fiap.main;

import br.com.fiap.bean.FolhaDePagamento;

public class Main {
    public static void main(String[] args){
        FolhaDePagamento pagamento = new FolhaDePagamento();
        pagamento.numeroDeDependentes = 9;
        pagamento.descontoINSS = 10;
        pagamento.salarioBruto = 10000;
        pagamento.valorPlanoDeSaude = 200;
        System.out.printf("O salario bruto: R$ %.2f;\nnumero de dependentes: %d\ndesconto do INSS: %.1f\nplano de saude: R$ %.2f\n salario liquido: %.2f", pagamento.salarioBruto, pagamento.numeroDeDependentes,
        pagamento.descontoINSS, pagamento.valorPlanoDeSaude, pagamento.calcularSalarioLiquido());
    }
}
