package br.com.fiap.main;

import br.com.fiap.bean.Televisor;

import java.util.Scanner;

public class ScannerTelevisor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Televisor televisor = new Televisor();
        int novaAcao;
        System.out.print("Me informe o canal desejado: ");
        televisor.setCanal(scan.nextInt());
        System.out.print("Me informe o volume desejado: ");
        televisor.setVolume(scan.nextInt());
        System.out.printf("O canal atual é: %d. \nO volume atual é: %d. ", televisor.getCanal(), televisor.getVolume());
        System.out.print("\n\nMenu \n• Digite 1 para: Definir outro canal. \n• Digite 2 para: Novo volume. \n•Digite 3 para: Aumentar o volume. \n•Digite 4 para: Diminuir o volume. \nOpção: ");
        novaAcao = scan.nextInt();
        try{
            if(novaAcao == 1){
                System.out.print("Me informe o novo canal: ");
                televisor.setCanal(scan.nextInt());
            } else if (novaAcao == 2){
                System.out.print("Me informe o novo volume: ");
                televisor.setVolume(scan.nextInt());
            } else if (novaAcao == 3){
                televisor.aumentarVolume();
                System.out.println("Aumentou Volume!");
            } else if (novaAcao == 4){
                televisor.diminuirVolume();
                System.out.println("Diminuiu volume!");
            } else {
                throw new Exception("Opção inválida no menu! (Digite 1, 2, 3 ou 4)");
            }
            System.out.printf("O canal atual é: %d. \nO volume atual é: %d. ", televisor.getCanal(), televisor.getVolume());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
