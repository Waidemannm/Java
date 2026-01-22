package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        setDataNascimento(dataNascimento );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        LocalDate inicio = LocalDate.parse("1900-12-31");
        LocalDate dataAtual = LocalDate.now().plusDays(1);
        try{
            if (dataNascimento.isAfter(inicio) && dataNascimento.isBefore(dataAtual)){
                this.dataNascimento = dataNascimento;
            } else{
                throw new Exception("A data de nascimento deve ser maior ou igual a 01/01/1900.");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
            System.exit(0); //encerra programa, novo valor padrão para atributo dataNascimento
        }
    }

    public int calcularIdade() {
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears();
    }
}
