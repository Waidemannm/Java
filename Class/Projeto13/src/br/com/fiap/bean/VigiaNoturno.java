package br.com.fiap.bean;

public class VigiaNoturno extends Funcionario{
    //atributos
    private float adicionalNoturno;
    //construtores
    public VigiaNoturno(){

    }
    public VigiaNoturno(float valorHoraTrabalho, String nome, float adicionalNoturno) {
        super(valorHoraTrabalho, nome);
        this.adicionalNoturno = adicionalNoturno;
    }
    //metodos getters and setters

    public float getAdicionalNoturno() {
        return adicionalNoturno;
    }

    public void setAdicionalNoturno(float adicionalNoturno) {
        this.adicionalNoturno = adicionalNoturno;
    }

    //metodos particulares
    public float calcularSalario(){
        return adicionalNoturno + (super.calcularSalario());
    }
}
