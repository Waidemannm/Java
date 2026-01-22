package br.com.fiap;

import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        int num1, num2,  resultado;
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        num1 = scan.nextInt();
        System.out.print("Digite outro numero: ");
        num2 = scan.nextInt();
        resultado = num1 * num2;
        System.out.println("O resultado da multiplicação é " + resultado);
    }
}
