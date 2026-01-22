package br.com.fiap;

public class UsarTelevisor {
    public static void main(String[] args) {
        Televisor televisorTeste = new Televisor();
        televisorTeste.canal = 102;
        televisorTeste.mudarCanal(18);
        televisorTeste.volume = 10;
        televisorTeste.diminuirVolume();
        televisorTeste.diminuirVolume();
        televisorTeste.aumentarVolume();
        System.out.println("O canal atual é "  + televisorTeste.canal + "\nO volume atual é " + televisorTeste.volume);
    }
}
