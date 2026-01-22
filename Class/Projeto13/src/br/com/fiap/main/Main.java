package br.com.fiap.main;

import br.com.fiap.bean.Quadrado;
import br.com.fiap.bean.Retangulo;
import br.com.fiap.bean.Triangulo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String auxiliar, escolha = "Sim";
        float lado, altura, area;
        int opcao;
        while (escolha.equalsIgnoreCase("Sim")){
            try {
               auxiliar = JOptionPane.showInputDialog("Qual area deseja calcular: \n1.Quadrado \n2. Retangulo \n3. Triangulo");
               opcao = Integer.parseInt(auxiliar);
                switch (opcao){
                    case 1:
                        auxiliar = JOptionPane.showInputDialog("Digite o valor do lado: ");
                        lado = Float.parseFloat(auxiliar);
                        Quadrado quad = new Quadrado(lado);
                        area = quad.calcularArea();
                        JOptionPane.showMessageDialog(null, String.format("A area do quadrao é %.2f", area));
                        break;
                    case 2:
                        auxiliar = JOptionPane.showInputDialog("Digite o valor do lado: ");
                        lado = Float.parseFloat(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite a altura do reatangulo");
                        altura = Float.parseFloat(auxiliar);
                        Retangulo ret = new Retangulo(lado, altura);
                        area = ret.calcularArea();
                        JOptionPane.showMessageDialog(null, String.format("A area do retangulo é %.2f", area));
                        break;
                    case 3:
                        auxiliar = JOptionPane.showInputDialog("Digite o valor do lado: ");
                        lado = Float.parseFloat(auxiliar);
                        auxiliar = JOptionPane.showInputDialog("Digite a altura do reatangulo");
                        altura = Float.parseFloat(auxiliar);
                        Triangulo tri = new Triangulo(lado, altura);
                        area = tri.calcularArea();
                        JOptionPane.showMessageDialog(null, String.format("A area do Triangulo é %.2f", area));
                        break;
                    default:
                       throw new Exception("Digite uma das opções possivéis!");
                }
                escolha = JOptionPane.showInputDialog("Deseja continuar?");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(null, "Obrigado! VOlte sempre!");
    }
}
