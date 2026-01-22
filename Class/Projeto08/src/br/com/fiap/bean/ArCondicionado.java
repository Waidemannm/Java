package br.com.fiap.bean;

import javax.swing.*;

public class ArCondicionado {
    //atributos
    private int temperatura;
    private String modo;
    private int novaAcao;
    //metodos getters and setters

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        try{
            if(temperatura >= 15 && temperatura <= 26){
                this.temperatura = temperatura;
            } else {
                String erro = "Temperatura inválida! (min= 15°C e max= 26°C)";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        try{
            if (modo.equalsIgnoreCase("Ventilar") || modo.equalsIgnoreCase("Aquecer") || modo.equalsIgnoreCase("Resfriar")){
                this.modo = modo;
            } else {
                String erro = "Escolha um modo válido! (Ventilar, Aquecer ou Resfriar)";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public int getNovaAcao(){
        return novaAcao;
    }
    public void setNovaAcao(int novaAcao){
        this.novaAcao = novaAcao;
    }

    //metodos da classe
    public void aumentarTemperatura(){
        if(temperatura < 26){
            temperatura++;
        }
    }
    public void diminuirTemperatura(){
        if (temperatura > 15){
            temperatura--;
        }
    }
}
