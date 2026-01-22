package br.com.fiap.main;

import javax.swing.*;
import java.util.*;

public class SorteioHashSet {
    public static void main(String[] args) {
        HashSet<Integer> numerosSorteados = new HashSet<Integer>();
        Random random = new Random();
        do {
            while(numerosSorteados.size() < 6){
                int numero = random.nextInt(1, 61);
                numerosSorteados.add(numero);
            }
            ArrayList<Integer> resultadoSorteio = new ArrayList<Integer>(numerosSorteados);
            Collections.sort(resultadoSorteio);
            JOptionPane.showMessageDialog(null, "Números Sorteados: \n" + resultadoSorteio, "Mega sorteio", JOptionPane.WARNING_MESSAGE);
            numerosSorteados.clear();
        }while (JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);{
            JOptionPane.showMessageDialog(null, "Fim de programa", "Adeus", JOptionPane.WARNING_MESSAGE);

        }
    }
}
