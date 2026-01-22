package br.com.fiap.bean;

import javax.swing.*;

public class Medico {
    //atributos
    private int idMedico;
    private String nome;
    private int crm;
    private String especialidade;
    //cosntrutores
    public Medico(){

    }

    public Medico(int idMedico, String nome, int crm, String especialidade) {
        setIdMedico(idMedico);
        this.nome = nome;
        setCrm(crm);
        this.especialidade = especialidade;
    }

    //metodos getters and setters
    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        try{
            if (idMedico > 0 && idMedico < 1000000000){
                this.idMedico = idMedico;
            }else{
                throw new Exception("Informe um ID de Médico válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        try{
            if (crm >= 1 && crm <= 99999999){
                this.crm = crm;
            }else {
                throw new Exception("CRM inválido. Deve conter apenas números entre 4 e 8 dígitos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    //metodos particulares
    public void atualizarEspecialidade(){
        String novaEspecialidade = JOptionPane.showInputDialog("Digite a nova especialidade: ");
        this.especialidade = novaEspecialidade;
    }
    public void exibirMedico(){
        JOptionPane.showMessageDialog(null, String.format("=== Médico === \nNome: %s \nId do Médico: %d \nCRM: %d \nEspecialidade: %s", getNome(), getIdMedico(), getCrm(), getEspecialidade()), "Médico", JOptionPane.INFORMATION_MESSAGE);
    }
}
