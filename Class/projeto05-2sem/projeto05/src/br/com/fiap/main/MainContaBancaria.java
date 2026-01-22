package br.com.fiap.main;

import br.com.fiap.bean.ContaBancaria;
import br.com.fiap.exception.SaldoInsuficienteExceptions;

public class MainContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000.0);
        try{
            conta.sacar(1500);
        }catch (SaldoInsuficienteExceptions e) {
            System.out.printf("Erro: " + e.getMessage());
        }
    }
}
