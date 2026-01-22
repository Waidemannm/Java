package br.com.fiap.main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String frase = "Batatinha frita";
        JOptionPane.showMessageDialog(null, frase);
        //qntd de caracteres
        JOptionPane.showMessageDialog(null, frase.length());
        //frase em maiusculo e depois em minusculo
        JOptionPane.showMessageDialog(null, frase.toUpperCase() + frase.toLowerCase());
        //exibe os caracteres de indice 0 a 9, "Batatinha"
        JOptionPane.showMessageDialog(null, frase.substring(0, 9));
        // Troca a cadeia de caracteres Batatinha por Uva
        JOptionPane.showMessageDialog(null, frase.replace("Batatinha", "Uva"));
        String senha = JOptionPane.showInputDialog("Digite a senha:");
        //senha deve ser identica
        if(senha.equals("P4ssw0rD")){
            JOptionPane.showMessageDialog(null, "Senha autorizada");
        }else{
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
        //senha deve ser igual, ignorando maiusculo
        if (senha.equalsIgnoreCase("P4ssw0orD")){
            JOptionPane.showMessageDialog(null, "Acesso concedio");
        }else{
            JOptionPane.showMessageDialog(null, "Acesso impedido");
        }
    }
}
