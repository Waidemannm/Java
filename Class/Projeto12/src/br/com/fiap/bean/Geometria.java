package br.com.fiap.bean;

import javax.swing.*;

public class Geometria {
    //atributos
    private float lado;
    private float altura;
    private double raio;
    //construtor vazio
    public Geometria() {
    }

    //metodos getters and setters
    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    //metodso partiulares
    public void calcularArea(float lado){
        float area = this.lado * this.lado;
        JOptionPane.showMessageDialog(null, String.format("A area do quadrado é: %.2f", area));
    }
    public void calcularArea(float lado, float altura){
        float area = this.lado * this.altura;
        JOptionPane.showMessageDialog(null, String.format("A area do retangulo é: %.2f", area));
    }
    public void calcularArea(double raio){
        double area = Math.PI * Math.pow(this.raio, 2);
        JOptionPane.showMessageDialog(null, String.format("A area do retangulo é: %.2f", area));
    }
}
