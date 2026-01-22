package br.com.fiap.main;

import br.com.fiap.bean.Funcionario;

import java.time.LocalDate;
import java.util.Scanner;

public class MainFunc2 {
    public static void main(String[] args) {
        Funcionario funcionario2;
        Scanner scan;
        float salario;
        LocalDate dataAtual;
        try{
            dataAtual = LocalDate.now();
            scan = new Scanner(System.in);
            System.out.println("Me informe o nome do funcionário e o valor da hora trabalhada:");
            funcionario2 = new Funcionario(scan.nextLine(), scan.nextFloat());
            System.out.println("Agora me informe a quantidade de horas trabalhadas por esse funcionário: ");
            salario = funcionario2.calcularSalario(scan.nextInt());
            System.out.printf("O nome do funcionário é: %s \nO seu salário é: %.2f \n %d/%d/%d", funcionario2.getNome(), salario, dataAtual.getDayOfMonth(), dataAtual.getMonthValue(), dataAtual.getYear());
        } catch (Exception e) {
            System.out.println("Me informe dados válidos");
        }
    }
}
