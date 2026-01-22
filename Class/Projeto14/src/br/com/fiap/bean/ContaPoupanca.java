
package br.com.fiap.bean;

public class ContaPoupanca extends ContaBancaria{
    // atributos
    private int diaDeRendimento;
    // construtores
    public ContaPoupanca() {
    }
    // métodos getters/setters
    public int getDiaDeRendimento() {
        return diaDeRendimento;
    }
    public void setDiaDeRendimento(int diaDeRendimento) {
        this.diaDeRendimento = diaDeRendimento;
    }
    // métodos da classe (particulares)
    public float novoSaldo(float rendimento) {
        float novoSaldo = super.getSaldo() * (1 + rendimento / 100);
        super.setSaldo(novoSaldo);
        return super.getSaldo();
    }
}

