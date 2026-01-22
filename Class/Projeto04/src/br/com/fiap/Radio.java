package br.com.fiap;

public class Radio {
    //atributos
    public int volume;
    public float estacao;
    //metodos
    public void aumentarVolume(){
        volume++;
    }
    public void diminuirVolume(){
        volume--;
    }
    public void mudarEstacao(float frequencia){
        estacao = frequencia;
    }
}

