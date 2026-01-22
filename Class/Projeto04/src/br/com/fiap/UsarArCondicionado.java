package br.com.fiap;

public class UsarArCondicionado {
    public static void main(String[] args) {
        ArCondicionado arTeste = new ArCondicionado();
        arTeste.modo = "Aquecer";
        arTeste.temperatura = 25;
        arTeste.trocarModo("Resfriar");
        arTeste.diminuirTemperatura();
        arTeste.diminuirTemperatura();
        arTeste.diminuirTemperatura();
        arTeste.diminuirTemperatura();
        arTeste.diminuirTemperatura();
        System.out.println("O modo atual é " + arTeste.modo + "\nA temperatura atual é " + arTeste.temperatura);

    }
}
