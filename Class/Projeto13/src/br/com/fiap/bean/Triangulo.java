package br.com.fiap.bean;

public class Triangulo extends Quadrado {
    //atributos
    private float altura;
    //construtores
    public Triangulo(){

    }
    public Triangulo(float lado, float altura) {
        super(lado);
        this.altura = altura;
    }
    //metodos getters and setters

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    //metodos particulares
    public float calcularArea(){
        return altura * super.getLado() / 2;
    }
}