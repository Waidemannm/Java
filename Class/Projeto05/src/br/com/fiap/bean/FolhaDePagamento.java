package br.com.fiap.bean;

public class FolhaDePagamento {
    public double salarioBruto;
    public int numeroDeDependentes;
    public double descondoINSS;
    public double valorPlanoDeSaude;

    public double calcularSalarioLiquido(){
        double desc1 = salarioBruto * (descondoINSS/100);
        double desc2 = (numeroDeDependentes + 1) * valorPlanoDeSaude;
        double salario = salarioBruto - desc1 - desc2;
        return salario;
    }
}
