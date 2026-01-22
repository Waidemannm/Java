package br.com.fiap.bean;

import javax.swing.*;

public class Equipe {
    //atributos
    private String nome;
    private String[] integrantes;
    //construtores
    public Equipe(){

    }
    public Equipe(String nome, String[] integrantes) {
        this.nome = nome;
        this.integrantes = integrantes;
    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(String[] integrantes) {
        this.integrantes = integrantes;
    }
    //metodos particulares
    public void listarEquipe() {
        String exibe = String.format("Nome: %s \n", nome);
        int cont = 1;
        for (String i : integrantes) {
            exibe += String.format("Integrante %d: %s \n", cont, i);
            cont ++;
        }
        JOptionPane.showMessageDialog(null, exibe, "Listagem da Equipe", JOptionPane.INFORMATION_MESSAGE);
    }
}
