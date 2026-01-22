package br.com.fiap.main;

import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class pokemoHashSet {
    public static void main(String[] args) {
        HashMap<String, String> pokemons= new HashMap<String, String>();
        do {
            try{
                String nome, tipo;
                do {
                nome = JOptionPane.showInputDialog("Digite o nome de um Pokémon ou digite \"FIM\" para encerrar.");
                if (!nome.equalsIgnoreCase("FIM")){
                    if (pokemons.containsKey(nome)){
                        JOptionPane.showMessageDialog(null, "Este pokémon já foi cadastrado!");
                    }else {
                        tipo = JOptionPane.showInputDialog("Digite o tipo do pokémon");
                        pokemons.put(nome, tipo);
                    }
                }
                }while (!nome.equalsIgnoreCase("FIM"));
                String escolha = JOptionPane.showInputDialog("Digite o tipo de um pokémon da sua escolha.").toUpperCase();
                ArrayList<String> nomesEncontrados = new ArrayList<>();

                for(Map.Entry<String, String> pokemon : pokemons.entrySet()){
                    if (pokemon.getValue().equals(escolha)) {
                        nomesEncontrados.add(pokemon.getKey());
                    }
                }
                JOptionPane.showMessageDialog(null, String.format("Para o tipo: %s foram encontrado(s) o(s) pokémon(s): \n%s", escolha, nomesEncontrados), "Encontrado", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        }while (JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        {
            JOptionPane.showMessageDialog(null, "Fim de programa", "Adeus", JOptionPane.WARNING_MESSAGE);

        }
    }
}
