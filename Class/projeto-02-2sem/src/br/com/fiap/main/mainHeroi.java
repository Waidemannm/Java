package br.com.fiap.main;

import br.com.fiap.bean.SuperHeroi;

import javax.swing.*;
import java.util.ArrayList;

public class mainHeroi {
    public static void main(String[] args) {
        SuperHeroi heroi;
        String nome, auxiliar, id;
        ArrayList<String> poderes;
        ArrayList<String> fraquezas;
        do {
            try{
                nome = JOptionPane.showInputDialog("Informe o nome do Herói:");
                id = JOptionPane.showInputDialog("Indentidade secreta:");
                String poder = "continua";
                String fraqueza = "continua";
                poderes = new ArrayList<String>();
                fraquezas = new ArrayList<String>();
                while (poder.equalsIgnoreCase("continua")){
                    auxiliar = JOptionPane.showInputDialog("Digite os poderes desse herói ou \"fim\" para parar");
                    if (auxiliar.equalsIgnoreCase("fim")){
                        poder = "fim";
                    }else {
                        poderes.add(auxiliar);
                    }
                }
                while(fraqueza.equalsIgnoreCase("continua")){
                    auxiliar = JOptionPane.showInputDialog("Digite as fraqueazas desse herói ou \"fim\" para parar");
                    if (auxiliar.equalsIgnoreCase("fim")){
                        fraqueza = "fim";
                    }else {
                        fraquezas.add(auxiliar);
                    }
                }
                heroi = new SuperHeroi(nome, id, poderes, fraquezas);
                heroi.listarHeroi();
                poderes.clear();
                fraquezas.clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }while (JOptionPane.showConfirmDialog(null, "deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa", "Adeus!", JOptionPane.WARNING_MESSAGE);
    }
}
