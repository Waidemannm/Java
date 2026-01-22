package br.com.fiap;

import java.util.Scanner;

public class ex3 {
     public static void main(String[] args) {
          float lado, resultado;
          Scanner scan = new Scanner(System.in);
          System.out.print("Digite o lado do quadrado: ");
          lado = scan.nextFloat();
          resultado = lado * lado;
          System.out.print("A area do quadrado é " + resultado);
   }
}
