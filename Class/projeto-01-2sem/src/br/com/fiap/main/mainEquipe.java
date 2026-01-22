package br.com.fiap.main;

import br.com.fiap.bean.Equipe;

import javax.swing.*;

public class mainEquipe {
    public static void main(String[] args) {
        Equipe grupo;
        String nome;
        String[] integrantes;
        int qtde;
        do{
            try {
                nome = JOptionPane.showInputDialog("Digite o nome da equipe: ");
                qtde = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de integrantes: "));
                integrantes = new String[qtde];
                for (int i = 0; i < integrantes.length ; i++) {
                    integrantes[i] = JOptionPane.showInputDialog(String.format("Nome do integrante %d: ", (i + 1)));

                }
                grupo = new Equipe(nome, integrantes);
                grupo.listarEquipe();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null, "deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa", "Adeus!", JOptionPane.WARNING_MESSAGE);
    }
}
