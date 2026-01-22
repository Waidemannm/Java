package br.com.fiap.bean;

import javax.swing.*;

public class Unidade {
    //atributos
    private int idUnidade;
    private String endereco;
    private int numero;
    private String telefone;
    //cosntrutores
    public Unidade(){

    }
    public Unidade(int idUnidade, String telefone, int numero, String endereco) {
        setIdUnidade(idUnidade);
        setTelefone(telefone);
        setNumero(numero);
        setEndereco(endereco);
    }
    //metodos getters and setters
    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        try{
            if (idUnidade > 0 && idUnidade < 1000000000){
                this.idUnidade = idUnidade;
            }else{
                throw new Exception("Informe um ID de Paciente válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        try{
            if(endereco != null){
                this.endereco = endereco;
            }else {
                throw new Exception("Informe um endereço válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        try{
            if (numero > 0){
                this.numero = numero;
            }else{
                throw new Exception("Informe um número de endereço válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        try{
            if (telefone != null && telefone.length() == 10){
                this.telefone = telefone;
            }else {
                throw new Exception("Formato inválido de telefone (Que tenha 10 ou 11 dígitos).");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodos particulares
    public String formatarEndereco(){
        return "Endereço: " + getEndereco() + ", N° " + getNumero();
    }
    public  String formatarTelefone() {
        return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7, 11);
    }
}
