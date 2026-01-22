package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;

public class Atendente extends Pessoa {
    //atributos
    private int idAtendete;

    //cosntrutores
    public Atendente() {

    }

    public Atendente(int idAtendete, String nome, String cpf, LocalDate dataNascimento) {
        setIdAtendete(idAtendete);
        super.setNome(nome);
        super.setCpf(cpf);
        super.setDataNascimento(dataNascimento);
    }

    //metodos getters and setters
    public int getIdAtendete() {
        return idAtendete;
    }

    public void setIdAtendete(int idAtendete) {
        try {
            if (idAtendete > 0 && idAtendete < 1000000000) {
                this.idAtendete = idAtendete;
            } else {
                throw new Exception("Informe um ID de Atendente válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodos particulares
    public void iniciarAtendimento() {
        JOptionPane.showMessageDialog(null, "Atendimento iniciado pelo atendente " + getNome(), "Atendente", JOptionPane.INFORMATION_MESSAGE);
    }
    public void encerrarAtendimento() {
        JOptionPane.showMessageDialog(null, String.format("Atendimento encerrado por %s ", getNome()), "Atendente", JOptionPane.INFORMATION_MESSAGE);
    }
}
