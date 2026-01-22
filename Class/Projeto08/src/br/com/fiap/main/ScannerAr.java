package br.com.fiap.main;

import br.com.fiap.bean.ArCondicionado;

import java.util.Scanner;

public class ScannerAr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArCondicionado ar = new ArCondicionado();
        int novaAcao;
        System.out.print("Me informe o modo desejado: ");
        ar.setModo(scan.nextLine());
        System.out.print("Me informe a temperatura deseja: ");
        ar.setTemperatura(scan.nextInt());
        System.out.printf("O modo atual do ar é: %s. \nA temperartura atual é: %d.", ar.getModo(), ar.getTemperatura());
        System.out.print("\n\nMenu \n•Digite 1 para: Mudar de modo. \n•Digite 2 para: Aumentar a temperatura. \n•Digite 3 para: Diminuir a temperatura. \nOpção: ");
        novaAcao = scan.nextInt();
        try{
            if(novaAcao == 1){
                System.out.print("Digite o novo modo: ");
                ar.setModo(scan.next());
            } else if (novaAcao == 2) {
                ar.aumentarTemperatura();
                System.out.println("Você aumentou a temperatura em 1°C!");
            } else if (novaAcao == 3) {
                ar.diminuirTemperatura();
                System.out.println("Você diminuiu a temperatura em 1°C!");
            } else {
                System.out.println("Essa opção não está no menu! (Digite 1, 2 ou 3");
            }
            System.out.printf("O modo atual do ar é: %s. \nA temperatura é: %d", ar.getModo(), ar.getTemperatura());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
