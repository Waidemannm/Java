package br.com.fiap;

public class VideoGame {
    public String modelo;
    public String jogo;
    public String status;
    public void mudarJogo(String novoJogo){
        jogo = novoJogo;
    }
    public void ligar(String statusOn){
        status = statusOn;
    }
    public void desligar(String statusOff){
        status = statusOff;
    }
}
