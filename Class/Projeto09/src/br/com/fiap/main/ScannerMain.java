package br.com.fiap.main;

import br.com.fiap.bean.Pessoa;

import java.util.Scanner;

public class ScannerMain {
    public static void main(String[] args) {
        Pessoa pessoa1;
        Scanner scan;
        String nome1;
        int anoNascimento;
        int idade;
        try{

                scan = new Scanner(System.in);
                System.out.println("Me informe seu nome e ano de nascimento ");
                //nome1 = scan.nextLine();
                //anoNascimento = scan.nextInt()
                pessoa1 = new Pessoa(scan.nextLine(), scan.nextInt());
                idade = pessoa1.calcularIdade(2025);
                System.out.printf("O nome da pessoa 1 é: %s \nA idade dele é: %d", pessoa1.getNome(), idade);
        } catch (Exception e) {
            System.out.println("Insira dados válidos em nome e ano de nascimento!");
        }
    }
}
