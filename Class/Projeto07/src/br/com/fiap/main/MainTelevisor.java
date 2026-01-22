package br.com.fiap.main;

import br.com.fiap.bean.Televisor;

public class MainTelevisor {
    public static void main(String[] args) {
        Televisor televisor = new Televisor();
        televisor.setVolume(18);
        televisor.setCanal(7);
        televisor.aumentarVolume();
        televisor.aumentarVolume();
        televisor.diminuirVolume();
        televisor.diminuirVolume();
        televisor.diminuirVolume();
        televisor.setCanal(13);
        System.out.printf("O volume atual é: %d. \nO canal atual é: %d.", televisor.getVolume(), televisor.getCanal());
    }
}
