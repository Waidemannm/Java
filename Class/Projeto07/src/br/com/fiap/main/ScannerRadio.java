package br.com.fiap.main;

import br.com.fiap.bean.Radio;

import java.util.Scanner;

public class ScannerRadio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Radio radio = new Radio();
        System.out.print("Digite a estação desejada: ");
        radio.setEstacao(scan.nextFloat());
        System.out.print("Digite o volume desejado: ");
        radio.setVolume(scan.nextInt());
        System.out.printf("A estação atual é %.1f. \nO volume atual é %d", radio.getEstacao(), radio.getVolume());
    }
}

