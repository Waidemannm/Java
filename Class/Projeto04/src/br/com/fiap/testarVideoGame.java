package br.com.fiap;

public class "testarVideoGame {
    public static void main(String[] args) {
        VideoGame testarVideoGame = new VideoGame();
        testarVideoGame.modelo = "Xbox";
        testarVideoGame.status = "off";
        testarVideoGame.ligar("On");
        testarVideoGame.jogo = "Fortnite";
        testarVideoGame.mudarJogo("Fifa");
        testarVideoGame.desligar("Off");
        testarVideoGame.ligar("On");

        System.out.println("Nesse momento seu " + testarVideoGame.modelo + " está " + testarVideoGame.status + "\nVoce estava jogando " + testarVideoGame.jogo);
    }
}
