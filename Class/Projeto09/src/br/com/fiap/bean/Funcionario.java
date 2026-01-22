package br.com.fiap.bean;

public class Funcionario {
    //atributos
    private String nome;
    private float valorHoraTrabalho;
    //construtores
    public Funcionario() {
    }

    public Funcionario(String nome, float valorHoraTrabalho) {
        this.nome = nome;
        setValorHoraTrabalho(valorHoraTrabalho);
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
        try{
            if (valorHoraTrabalho > 0){
                this.valorHoraTrabalho = valorHoraTrabalho;
            }else {
                throw new Exception("O valor da hora trabalhada deve ser maiior que 0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //metodos particulares da classe
    public float calcularSalario(float qtdeHorasTrabalhadaSemana){
        return qtdeHorasTrabalhadaSemana * valorHoraTrabalho * 4;
    }
}
