package br.com.fiap.bean;

import javax.swing.*;

public class Medicamento {
    //atributos
    private int idMedicamento;
    private String nome;
    private String indicacoes;
    //cosntrutores
    public Medicamento(){

    }
    public Medicamento(int idMedicamento, String nome, String indicacoes) {
        this.idMedicamento = idMedicamento;
        this.nome = nome;
        this.indicacoes = indicacoes;
    }

    //metodos getters and setters
    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        try{
            if (idMedicamento> 0 && idMedicamento < 1000000000){
                this.idMedicamento = idMedicamento;
            }else{
                throw new Exception("Informe um ID de Pagamento válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    //metodos particulares
    public void atualizarindicacoes(){
        String  novaIndicacao = JOptionPane.showInputDialog("Digite as novas indicações: ");
        this.indicacoes = novaIndicacao;
    }
    public void exibirMedicamento(){
        JOptionPane.showMessageDialog(null, String.format("=== Medicamento === \nMedicamento: %s \nId Medicamento: %d \nIndicações: %s", getNome(), getIdMedicamento(), getIndicacoes()), "Medicamento", JOptionPane.INFORMATION_MESSAGE);
    }
}
