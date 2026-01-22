package br.com.fiap.bean;

/**
 * Classe para obejos ContaEspecial
 * @author Moisés Waidemann
 * @version 1.0
 */
public class ContaEspecial implements ContaBancaria{
    //atributos
    private int numConta;
    private float saldo;
    private float limite;
    //construtores
    public ContaEspecial(){

    }

    //metodos getters and setters
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }



    //metodos particulares
    /**
     * Metodo utilizado para fazer saque do valor
     * @author Moisés Waidemann
     * @param valor - Deve ser menor ou igual ao saldo
     * @return -  retorna o saldo atualizado
     */
    public float sacar(float valor) {
        try{
            if (valor <= (saldo +limite)){
                saldo -= valor;
            }else{
                throw new Exception("Saldo isuficiente!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return saldo;
    }

    /**
     *
     * @author Moisés Waidemann
     * @param valor - valor a ser depositado
     * @return - retorna o saldo atualizado
     */
    public float depositar(float valor) {
        saldo += valor;
        return saldo;
    }
}
