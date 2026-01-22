package br.com.fiap.main;

import br.com.fiap.bean.ArCondicionado;

public class Main {
    public static void main(String[] args) {
        ArCondicionado ar = new ArCondicionado();
        ar.setModo("Aquecer");
        ar.setModo("Resfriar");
        ar.setTemperatura(17);
        ar.aumentarTemperatura();
        ar.aumentarTemperatura();
        ar.aumentarTemperatura();
        ar.diminuirTemperatura();
        ar.setModo("Aquecer");
        System.out.printf("O modo atual do ar é: %s. \nA temperatura é: %d.", ar.getModo(), ar.getTemperatura());
    }
}
