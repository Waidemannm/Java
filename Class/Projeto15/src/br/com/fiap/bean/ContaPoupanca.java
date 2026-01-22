package br.com.fiap.bean;

/**
 *Classe para objetos do tipo ContaPoupanca
 * @author Moisés Waidemanmm
 * @version 1.0
 */

public class ContaPoupanca implements ContaBancaria{
    //atributos
    private int numConta;
    private float saldo;
    //construtores
    public ContaPoupanca(){

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




    //metodos particulares
    /**
     *Metodo usado para sacar valor do atributo saldo
     * O valor não pode ser maior que valor do saldo atual
     * @author Moisés Wademann
     * @param valor - valor a ser sacado
     * @return - valor do saldo atualizado após o saque
     */
    public float sacar(float valor){
        try{
            if (valor <= saldo){
                saldo -= valor;
            }else{
               throw new Exception("Saldo isuficiente");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return saldo;
    }

    /**
     * Metodo usado para depositar valor ao atributo saldo
     * @author Moisés Waidemann
     * @param valor - valor a ser depositado
     * @return - valor do saldo atualizado após o depósito
     */
    public float depositar(float valor){
        saldo += valor;
        return saldo;
    }
}
