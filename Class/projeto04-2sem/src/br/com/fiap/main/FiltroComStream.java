package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroComStream {
    public static void main(String[] args) {
        ArrayList<String> herois = new ArrayList<String>(
                Arrays.asList("Homem Aranha", "Wolverine", "Hulk", "Capitão América", "Homem Elástico", "Mulher Maravilha", "Pantera negra", "Viúva Negra", "Homem de Ferro", "Miss Marvel", "Mulher Invisível", "Cíclope")
        );
        List<String> heroisComH = herois.stream()
                .filter(heroi -> heroi.startsWith("H"))
                .collect(Collectors.toList());

        System.out.println("Heróis que começam com a letra \"H\": \n" + heroisComH);
    }
}
