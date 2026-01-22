package br.com.fiap;

import javax.swing.*;

public class ex2 {
    public static void main(String[] args) {
        int base, expoente;
        double potencia;
        String auxiliar = JOptionPane.showInputDialog("Digite um numero: ");
        base = Integer.parseInt(auxiliar);
        auxiliar = JOptionPane.showInputDialog("Digite outro numero: ");
        expoente = Integer.parseInt(auxiliar);
        potencia = Math.pow(base, expoente);
        JOptionPane.showMessageDialog(null, "A potencia é " + potencia);
    }
}
