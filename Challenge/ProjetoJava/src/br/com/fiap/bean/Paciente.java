package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;

public class Paciente extends Pessoa {
    //atributos
    private int idPaciente;

    //cosntrutores
    public Paciente() {

    }

    public Paciente(int idPaciente, String nome, String cpf, LocalDate dataNascimento) {
        setIdAtendete(idPaciente);
        super.setNome(nome);
        super.setCpf(cpf);
        super.setDataNascimento(dataNascimento);
    }

    //metodos getters and setters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdAtendete(int idPaciente) {
        try {
            if (idPaciente > 0 && idPaciente < 1000000000) {
                this.idPaciente = idPaciente;
            } else {
                throw new Exception("Informe um ID de Paciente válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodos particulares
    public void atualizarCadastro(){
        int novoIdPaciente;
        novoIdPaciente = Integer.parseInt(JOptionPane.showInputDialog("Digite o no ID do Paciente:"));
        if (novoIdPaciente > 0 && novoIdPaciente < 1000000000) {
            this.idPaciente = novoIdPaciente;
            JOptionPane.showMessageDialog(null, String.format("ID atualizado para: %d", novoIdPaciente), "Paciente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Formato inválido de ID, será mantido o ID anteriormente cadastrado!","ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do Paciente:");
        super.setNome(novoNome);
        JOptionPane.showMessageDialog(null, String.format("Nome atualizado para: %s", novoNome),"Paciente", JOptionPane.INFORMATION_MESSAGE);
        String novoCpf = JOptionPane.showInputDialog("Digite o novo cpd do Paciente:");
        if (novoCpf != null && novoCpf.length() == 11){
            super.setCpf(novoCpf);
        }else {
            JOptionPane.showMessageDialog(null, "Formato inválido de cpf, será mantido o cpf anteriormente cadastro!","ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void exibirPaciente(){
        JOptionPane.showMessageDialog(null, String.format("=== Pacieente === \nNome: %s \nId do Paciente: %d \nCPF: %s \nData de Nascimento: %s", getNome(), getIdPaciente(), getCpf(), getDataNascimento()), "Paciente", JOptionPane.INFORMATION_MESSAGE);
    }
}
