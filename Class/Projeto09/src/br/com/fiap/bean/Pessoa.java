package br.com.fiap.bean;

import java.time.LocalDate;

public class Pessoa {
    //atributos
    private String nome;
    private int anoNascimento;
    //construtores, primeiro o vazio e depois o com passagem d parametros
    public Pessoa() {

    }

    public Pessoa(String nome, int anoNascimento) {
        this.nome = nome;
        setAnoNascimento(anoNascimento);
    }
    //metodos getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        LocalDate dataAtual = LocalDate.now();
        try{
            if (anoNascimento >= 1900 && anoNascimento <= dataAtual.getYear()){
                this.anoNascimento = anoNascimento;
            } else {
                throw new Exception("O ano de nascimento não é válido! (entre 1900 e ano atual)");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //metodos particulares da classe
    public int calcularIdade(int anoAtual){
        return anoAtual - anoNascimento;
    }
}
