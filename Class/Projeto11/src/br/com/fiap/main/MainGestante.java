package br.com.fiap.main;

import br.com.fiap.bean.Gestante;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainGestante {
    public static void main(String[] args) {
        Gestante gestante1;
        LocalDate dataDaGestacao;
        String nome, data1, dataEUA;
        try{
            nome = JOptionPane.showInputDialog("Me diga seu nome:");

            data1 = JOptionPane.showInputDialog("Me informe a data de início da gestação (dia/mes/ano)");


            String ano = data1.substring(6, 10);
            String mes = data1.substring(3, 5);
            String dia = data1.substring(0, 2);

            dataEUA = ano + "-" + mes + "-" + dia;
            dataDaGestacao = LocalDate.parse(dataEUA);

            gestante1 = new Gestante(nome, dataDaGestacao);
            gestante1.setDataDaGestacao(dataDaGestacao);

            JOptionPane.showMessageDialog(null, String.format("Data da gestação no formato Americano: %s", dataDaGestacao));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            JOptionPane.showMessageDialog(null, String.format("Informações da gestante \nNome: %s \nData início gestação: %s \nTempo gestando: %s mês(es)", gestante1.getNome(), gestante1.getDataDaGestacao().format(dtf), gestante1.tempoDeGestacao()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
