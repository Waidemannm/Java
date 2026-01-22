package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Arrays;

public class FiltroSemStream {
    public static void main(String[] args) {
        ArrayList<String> herois = new ArrayList<String>(
                Arrays.asList("Homem Aranha", "Wolverine", "Hulk", "Capitão América", "Homem Elástico", "Mulher Maravilha", "Pantera negra", "Viúva Negra", "Homem de Ferro", "Miss Marvel", "Mulher Invisível", "Cíclope")
        );
        ArrayList<String> heroisComH = new ArrayList<String>();
        for (String i : herois){
            if (i.startsWith("H")){
                heroisComH.add(i);
            }
        }
        System.out.println("Heróis que começam com a letra \"H\": \n" + heroisComH);
    }
}
