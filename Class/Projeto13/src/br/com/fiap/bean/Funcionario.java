package br.com.fiap.bean;

public class Funcionario {
    //atributos
    private String nome;
    private float valorHoraTrabalho;
    //construtores
    public Funcionario(){

    }
    public Funcionario(float valorHoraTrabalho, String nome) {
        this.valorHoraTrabalho = valorHoraTrabalho;
        this.nome = nome;
    }
    //metodos getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorHoraTrabalho() {
        return valorHoraTrabalho;
    }

    public void setValorHoraTrabalho(float valorHoraTrabalho) {
        this.valorHoraTrabalho = valorHoraTrabalho;
    }

    //metodos particulares
    public float calcularSalario(){
        return (getValorHoraTrabalho() * 40) * 4;
    }
}
