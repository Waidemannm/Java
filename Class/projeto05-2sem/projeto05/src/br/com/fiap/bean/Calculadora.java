package br.com.fiap.bean;

public class Calculadora {
    //atributos
    private float numero1, numer2;
    //construtor vazio
    public Calculadora(){}
    //getters and setters
    public float getNumero1() {
        return numero1;
    }

    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    public float getNumer2() {
        return numer2;
    }

    public void setNumer2(float numer2) {
        this.numer2 = numer2;
    }
    //metodos particulares
    public float adicao(){
        return numero1 + numer2;
    }
    public float subtracao(){
        return numero1 - numer2;
    }
    public float multiplicacao(){
        return numero1 * numer2;
    }
    public float divisao () throws ArithmeticException {
        if (getNumer2() > 0){
            return numero1/numer2;
        } else {
            throw new ArithmeticException("Erro: Divisão por zero!");
        }
    }
}
