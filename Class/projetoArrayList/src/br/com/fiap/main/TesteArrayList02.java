package br.com.fiap.main;

import java.util.ArrayList;

import java.util.Collections;

public class TesteArrayList02 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(50);
        numeros.add(40);
        numeros.add(20);
        numeros.add(30);
        numeros.add(10);
        System.out.println("ArrayList orginal");
        for (Integer i : numeros){
            System.out.print(String.format("%d ", i));
        }
        System.out.println("\nArrayList ordenado");
        for (Integer i : numeros){
            //ordenando um ArrayList com o metodo .sort() da classe Colletions
            Collections.sort(numeros);
            System.out.print(String.format("\n%d ", i));
        }

    }
}
