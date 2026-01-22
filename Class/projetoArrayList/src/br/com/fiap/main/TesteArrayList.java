package br.com.fiap.main;

import java.util.ArrayList;

public class TesteArrayList {
    public static void main(String[] args) {
        //declaraçao e instanciaçao de objetos da classe ArrayList
        ArrayList<String> carros = new ArrayList<String>();
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        //preencher o ArrayList com o metodo .add()
        carros.add("Volvo");
        carros.add("BMW");
        carros.add("Ford");
        System.out.println("Tamanho do ArrayList: " + carros.size());
        System.out.println("Mostrando o valor do indice 1: " + carros.get(1));
        //trocando um valor com metodo .set()
        carros.set(1, "Volksvagem");
        System.out.println("Trocando o valor do indice 1: " + carros.get(1));
        //removendo um valor de um indice com .remove()
        carros.remove(1);
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }
        //limpando todos os valores do ArrayList
        carros.clear();

    }
}
