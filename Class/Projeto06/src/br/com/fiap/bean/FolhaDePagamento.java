package br.com.fiap.bean;

public class FolhaDePagamento {
    public double salarioBruto;
    public int numeroDeDependentes;
    public double descontoINSS;
    public double valorPlanoDeSaude;

    public double calcularSalarioLiquido(){
        double desc1, desc2, salarioLiquido;
        desc1 = salarioBruto * (descontoINSS/100);
        desc2 = valorPlanoDeSaude * (numeroDeDependentes + 1);
        salarioLiquido = salarioBruto - desc1 - desc2;
        return salarioLiquido;
    }
}
