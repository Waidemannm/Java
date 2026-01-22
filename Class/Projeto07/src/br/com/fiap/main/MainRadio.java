package br.com.fiap.main;

import br.com.fiap.bean.Radio;

public class MainRadio {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setVolume(68);
        radio.setEstacao(99.0f);
        radio.aumentarVolume();
        radio.aumentarVolume();
        radio.aumentarVolume();
        radio.dimnuiriVolume();
        radio.setEstacao(100.1f);
        System.out.printf("A estação atual é %.1fMhz. \nO volume atual é %d.", radio.getEstacao(), radio.getVolume());
    }
}
