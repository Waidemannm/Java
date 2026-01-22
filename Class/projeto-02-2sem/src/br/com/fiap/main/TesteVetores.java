package br.com.fiap.main;

public class TesteVetores {
    public static void main(String[] args) {
        String[] carros = {"Up", "Volvo", "Porsche", "Ford"};
        System.out.println(carros.length);
        int[] numeros = new int[4];
        numeros[0] = 856657670;
        numeros[1] = 175657560;
        numeros[2] = 765756730;
        numeros[3] = 47657560;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        for (String i : carros){
            System.out.println(i);
        }
    }
}
