package br.com.fiap.bean;

import br.com.fiap.exception.SaldoInsuficienteExceptions;

public class ContaBancaria {
    //atributos
    private double saldo;
    //cosntrutor c parametros
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }
    //getter
    public double getSaldo() {
        return saldo;
    }
    //metodos particulares
    public void sacar(double quantia) throws SaldoInsuficienteExceptions {
        if (quantia > saldo){
          throw new SaldoInsuficienteExceptions("Saldo insuficiente para realizar o saque!");
       }
        saldo -= quantia;
    }
}
