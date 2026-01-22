//Gabriel Sbrana Campos, rm565849
//Moisés Waidemann, rm563719
package br.com.fiap.main;

import br.com.fiap.bean.DespesaFamiliar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            DespesaFamiliar despesa = new DespesaFamiliar();
            Scanner scan = new Scanner(System.in);
            System.out.print("Digite o valor da renda familiar: ");
            despesa.rendaFamiliar = scan.nextDouble();
            System.out.print("Digite o números de moradores: ");
            despesa.numeroDeMoradores = scan.nextInt();
            System.out.print("Digite o gasto com conta de luz: ");
            despesa.gastoComLuz = scan.nextDouble();
            System.out.print("Digite o gasto com conta de água: ");
            despesa.gastoComAgua = scan.nextDouble();
            System.out.print("Digite com conta de internet: ");
            despesa.gastoComInternet = scan.nextDouble();
            System.out.print("Qual o valor da mensalidade da academia: ");
            despesa.valorMensalidadeDaAcademia = scan.nextDouble();
            despesa.calcularTotalDeDespensas();
            despesa.calcularRendaFamiliarLiquida();
            System.out.printf("O valor total da renda bruta é: %.3f\nO total de gastos com despesas é: %.3f" +
                    "\nO total do valor de renda familiar líquida é: %.3f", despesa.rendaFamiliar, despesa.calcularTotalDeDespensas(), despesa.calcularRendaFamiliarLiquida());
        } catch (Exception e) {
            System.out.print("Tipo de dado inválido!");
        }
    }
}
