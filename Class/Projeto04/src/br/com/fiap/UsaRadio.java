package br.com.fiap;

public class UsaRadio {
    public static void main(String[] args) {
        Radio radioTeste = new Radio(); //declara e instancia
        radioTeste.estacao = 89.1f;
        radioTeste.volume = 5;
        radioTeste.mudarEstacao(92.5f);
        radioTeste.aumentarVolume();
        radioTeste.aumentarVolume();
        System.out.println("O volume atual é " + radioTeste.volume + "\nEstcção atual é " + radioTeste.estacao);
    }
}
