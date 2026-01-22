package br.com.fiap.main;

import br.com.fiap.bean.Funcionario;

import java.time.LocalDate;

public class MainFunc1 {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("Girosvaldo");
        funcionario1.setValorHoraTrabalho(10.5f);
        float salario = funcionario1.calcularSalario(50);
        LocalDate dataAtual = LocalDate.now();
        System.out.printf("O nome do funcionáro 1 é: %s \nSeu salário é: %.2f \n%d/%s/%d", funcionario1.getNome(), salario, dataAtual.getDayOfMonth(), dataAtual.getMonth(), dataAtual.getYear());
    }
}
