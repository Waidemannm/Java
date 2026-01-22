package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    //atributos
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    //construtores
    public Pessoa(){

    }
    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    //metodos getterss and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        try{
            if (cpf != null && cpf.length() == 11){
                this.cpf = cpf;
            }else {
                throw new Exception("Informe um CPF válido!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        LocalDate inicio = LocalDate.parse("1900-12-31");
        LocalDate dataAtual = LocalDate.now().plusDays(1);
        try {
            if (dataNascimento.isAfter(inicio) && dataNascimento.isBefore(dataAtual)){
                this.dataNascimento = dataNascimento;
            } else {
                throw new Exception("A data de nascimento deve ser maior ou igual a 01/01/1900.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //metodos particulares
    public int verificarIdade(){
        LocalDate dataNascimento = getDataNascimento();
        LocalDate dataAtual = LocalDate.now().plusDays(1);
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears();
    }
    public String formatarData(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dtf.format(dataNascimento);
    }
}
