package br.com.fiap.main;

import br.com.fiap.bean.Geometria;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Geometria geo = new Geometria();
        String auxiliar, continuar = "Sim";
        float lado, altura;
        double raio;
        int opcao;
        try {
            auxiliar = JOptionPane.showInputDialog("Qual a forma para calcular a area: \n1.Quadrado \n2.Retangulo \n3.Circulo");
            opcao = Integer.parseInt(auxiliar);
            switch (opcao){
                case 1:
                    auxiliar = JOptionPane.showInputDialog("Informe o lado do quadrado:");
                    lado = Float.parseFloat(auxiliar);

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    throw new Exception("Informe dados válidos");
            }
            continuar = JOptionPane.showInputDialog("Deseja continuar?");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
