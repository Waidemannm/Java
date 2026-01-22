package br.com.fiap.bean;

import javax.swing.*;

public class SuperHeroi {
    //atributos
    private String nome;
    private String idSecreta;
    private String[] poderes;
    private  String[] fraqueza;
    //cosntrutores
    public SuperHeroi(){

    }
    public SuperHeroi(String nome, String idSecreta, String[] poderes, String[] fraqueza) {
        this.nome = nome;
        this.idSecreta = idSecreta;
        this.poderes = poderes;
        this.fraqueza = fraqueza;
    }
    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdSecreta() {
        return idSecreta;
    }

    public void setIdSecreta(String idSecreta) {
        this.idSecreta = idSecreta;
    }

    public String[] getPoderes() {
        return poderes;
    }

    public void setPoderes(String[] poderes) {
        this.poderes = poderes;
    }

    public String[] getFraqueza() {
        return fraqueza;
    }

    public void setFraqueza(String[] fraqueza) {
        this.fraqueza = fraqueza;
    }
    //particulares
    public void listarHeroi(){
        String exibe = String.format("Nome: %s \nId Secrete: %s", nome, idSecreta);
        for(String i : poderes){
            exibe += String.format("Poderes: %s \n", i);
        }
        for(String i : fraqueza){
            exibe += String.format("Fraquezas: %s \n", i);
        }
        JOptionPane.showMessageDialog(null, exibe, "Herói", JOptionPane.INFORMATION_MESSAGE);
    }
}
