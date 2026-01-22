package br.com.fiap.main;

import br.com.fiap.bean.DespesaFamiliar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DespesaFamiliar despesa = new DespesaFamiliar();
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o valor da renda familiar: ");
        despesa.rendaFamiliar = scan.nextDouble();
        System.out.print("Digite a quantidade de moradores: ");
        despesa.numeroDeMoradores = scan.nextInt();
        System.out.print("Digite o gasto com luz: ");
        despesa.gastoComLuz = scan.nextDouble();
        System.out.print("Diigite o gasto com água: ");
        despesa.gastoComAgua = scan.nextDouble();
        System.out.print("Digite o gasto com internet: ");
        despesa.gastoComIternet = scan.nextDouble();
        System.out.print("Digite o valor da mensalidade da academia: ");
        despesa.valorMensalidadeDaAcademia = scan.nextDouble();
        System.out.printf("O valor da renda bruta familiar é: %.3f\nO total de gastos é de: %.3f\nE o valo da renda líquida é de: %.3f",
                despesa.rendaFamiliar, despesa.calcularTotalDeDespesas(), despesa.calcularRendaFamiliarLiquida());
    }
}
