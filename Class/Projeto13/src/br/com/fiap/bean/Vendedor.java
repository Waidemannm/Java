package br.com.fiap.bean;

public class Vendedor extends Funcionario{
    //atributos
    private float comissao;
    //construtores
    public Vendedor(){

    }
    public Vendedor(float valorHoraTrabalho, String nome, float comissao) {
        super(valorHoraTrabalho, nome);
        this.comissao = comissao;
    }
    //metodos getters and setters

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    //metodos particulares
    public float calcularSalario(){
        return (super.calcularSalario() * (1 + comissao/100));
    }
}
