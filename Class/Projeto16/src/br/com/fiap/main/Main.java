package br.com.fiap.main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcao;
        do {
            try{
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha um tipo de menssagem: \n1. Pergunta \n2. Informção \n3. Alerta \n4. Erro"));
                switch (opcao){
                    case 1:
                        JOptionPane.showMessageDialog(null, "Menssagem com icone de PERGUNTA", "Pergunta", JOptionPane.QUESTION_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Menssagem com icone de INFORMAÇÂO", "Informação", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Menssagem com icone de ALERTA", "Alerta", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Menssagem com icone de ERRO", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Digite uma das opções disponiveis!", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja  continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa, Volte sempre!", "Adeus!", JOptionPane.WARNING_MESSAGE);

    }
}
