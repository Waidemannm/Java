package br.com.fiap.bean;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class SuperHeroi {
    //atributos
    private String nome;
    private String idSecreta;
    private ArrayList<String> poderes;
    private ArrayList<String> fraqueza;
    //cosntrutores
    public SuperHeroi(){

    }
    public SuperHeroi(String nome, String idSecreta, ArrayList<String> poderes, ArrayList<String>fraqueza) {
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

    public ArrayList<String> getPoderes() {
        return poderes;
    }

    public void setPoderes(ArrayList<String> poderes) {
        this.poderes = poderes;
    }

    public ArrayList<String> getFraqueza() {
        return fraqueza;
    }

    public void setFraqueza(ArrayList<String> fraqueza) {
        this.fraqueza = fraqueza;
    }
    //particulares
    public void listarHeroi(){
        String exibe = String.format("Nome: %s \nId Secrete: %s", nome, idSecreta);
        Collections.sort(poderes);
        for(String i : poderes){
            exibe += String.format("Poderes: %s \n", i);
        }
        Collections.sort(fraqueza);
        for(String i : fraqueza){
            exibe += String.format("Fraquezas: %s \n", i);
        }
        JOptionPane.showMessageDialog(null, exibe, "Herói", JOptionPane.INFORMATION_MESSAGE);
    }
}
