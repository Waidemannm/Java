package br.com.fiap.main;

import br.com.fiap.bean.Equipe;

import javax.swing.*;
import java.util.ArrayList;

public class mainEquipe {
    public static void main(String[] args) {
        Equipe grupo;
        String nome, auxiliar;
        ArrayList<String> integrantes;
        do{
            try {
                nome = JOptionPane.showInputDialog("Digite o nome da equipe: ");
                String membros = "continua";
                integrantes = new ArrayList<String>();
                while (membros.equalsIgnoreCase("continua")){
                    auxiliar = JOptionPane.showInputDialog("Digite o integrante desta equipe ou \"fim\" para encerrar");
                    if (auxiliar.equalsIgnoreCase("fim")){
                        membros = "fim";
                    }else {
                        integrantes.add(auxiliar);
                    }
                }
                grupo = new Equipe(nome, integrantes);
                grupo.listarEquipe();
                integrantes.clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }

        } while (JOptionPane.showConfirmDialog(null, "deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa", "Adeus!", JOptionPane.WARNING_MESSAGE);
    }
}
