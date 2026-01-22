package br.com.fiap.bean;

public class Quadrado {
    //atributos
    private float lado;
    //contrutores
    public Quadrado(){

    }

    public Quadrado(float lado) {
        this.lado = lado;
    }
    //metodos getters and setters

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }
    //metodos particulares
    public float calcularArea(){
        return lado * lado;
    }
}

