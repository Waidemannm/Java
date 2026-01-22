package br.com.fiap.main;

import br.com.fiap.bean.FolhaDePagamento;

import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) {
        FolhaDePagamento pagando = new FolhaDePagamento();
        double salarioBruto, descontoINSS, valorPlanoDeSaude;
        int numeroDeDependentes;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Digite seu sálario bruto: ");
            pagando.salarioBruto = scan.nextDouble();
            System.out.print("Digite seu o numero de dependetes: ");
            pagando.numeroDeDependentes = scan.nextInt();
            System.out.print("Digite o valor do seu plano de saude: ");
            pagando.valorPlanoDeSaude = scan.nextDouble();
            System.out.print("Digite o desconto do INSS: ");
            pagando.descontoINSS = scan.nextDouble();
            System.out.printf("O salario bruto é: R$ %.2f;\nA quantidade de dependentes são: %d" +
                    "\nO desconto do INSS: %.1f\nO valor do plano de saude é: R$ %.2f\nSeu salario liquido é: %.2f", pagando.salarioBruto, pagando.numeroDeDependentes,
                    pagando.descontoINSS, pagando.valorPlanoDeSaude, pagando.calcularSalarioLiquido());
        } catch (Exception e){
            System.out.println("Forma numerica errada!");
        }
    }
}
