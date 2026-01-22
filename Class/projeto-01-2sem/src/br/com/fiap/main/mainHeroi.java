package br.com.fiap.main;

import br.com.fiap.bean.SuperHeroi;

import javax.swing.*;

public class mainHeroi {
    public static void main(String[] args) {
        SuperHeroi heroi;
        String nome;
        String id;
        String[] poderes;
        String[] fraquezas;
        int qtdPoder;
        int qtdFraqueza;
        do {
            try{
                nome = JOptionPane.showInputDialog("Informe o nome do Herói: ");
                id = JOptionPane.showInputDialog("Indentidade secreta:");
                qtdPoder = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de poderes do herói: "));
                poderes = new String[qtdPoder];
                for (int i = 0; i < poderes.length; i++) {
                    poderes[i] = JOptionPane.showInputDialog(String.format("Poder %d:",(i + 1)));
                }
                qtdFraqueza = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de fraquezas do herói: "));
                fraquezas = new String[qtdFraqueza];
                for (int i = 0; i < fraquezas.length; i++) {
                    fraquezas[i] = JOptionPane.showInputDialog(String.format("Fraqueza %d: ", (i + 1)));
                }
                heroi = new SuperHeroi(nome, id, poderes, fraquezas);
                heroi.listarHeroi();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }while (JOptionPane.showConfirmDialog(null, "deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa", "Adeus!", JOptionPane.WARNING_MESSAGE);
    }
}
