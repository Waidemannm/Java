package br.com.fiap.main;

import br.com.fiap.bean.Pessoa;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa("Berisvaldo", 2000);

        pessoa1.setNome("Astrogildo");
        pessoa1.setAnoNascimento(1998);
        int idadePessoa1 = pessoa1.calcularIdade(2025);
        System.out.printf("O nome da pessoa 1 é: %s \nA idade dele é: %d", pessoa1.getNome(), idadePessoa1);


        int idadePessoa2 = pessoa2.calcularIdade(2025);
        System.out.printf("\n\nO nome da pessoa 2 é: %s \nA idade dele é: %d", pessoa2.getNome(), idadePessoa2);
    }
}
