package br.com.fiap.main;

import br.com.fiap.bean.ArCondicionado;

import javax.swing.*;

public class JOpitionPaneAr {
    public static void main(String[] args) {
        ArCondicionado ar = new ArCondicionado();
        String auxiliar;
        int novaAcao = 0;
        auxiliar = JOptionPane.showInputDialog("Me informe o modo desejado: ");
        ar.setModo(auxiliar);
        auxiliar = JOptionPane.showInputDialog("Me informe a temperatura desejada: ");
        ar.setTemperatura(Integer.parseInt(auxiliar));
        String mensagem = String.format("O modo atual do ar é: %s. \nA temperatura é: %d", ar.getModo(), ar.getTemperatura());
        JOptionPane.showMessageDialog(null, mensagem);
        /* JOptionPane.showMessageDialog(null, "O Modo atual do ar é: " + ar.getModo() + "\nA temperatura é: " + ar.getTemperatura()); Mensagem usando concatenção*/
        auxiliar = JOptionPane.showInputDialog("\n\nMenu \n•Digite 1 para: Mudar de modo. \n•Digite 2 para: Aumentar a temperatura. \n•Digite 3 para: Diminuir a temperatura. \nOpção: ");
        ar.setNovaAcao(Integer.parseInt(auxiliar));

        try{
            if (novaAcao == 1){
                auxiliar = JOptionPane.showInputDialog("Me informe o novo modo desejado: ");
                ar.setModo(auxiliar);
            } else if (novaAcao == 2) {
                ar.aumentarTemperatura();
                JOptionPane.showMessageDialog(null, "Você aumentou a temperatura em 1°C.");
            } else if (novaAcao == 3) {
                ar.diminuirTemperatura();
                JOptionPane.showMessageDialog(null, "Você diminuiu a temperatura em 1°C.");
            } else {
                String erro = "Esta opção é inválida no menu! (Digite 1, 2 ou 3";
            }
            JOptionPane.showMessageDialog(null, mensagem);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}