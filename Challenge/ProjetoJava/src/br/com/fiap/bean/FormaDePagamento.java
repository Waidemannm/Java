package br.com.fiap.bean;

import javax.swing.*;

public class FormaDePagamento {
    //atributos
    private int idPagamento;
    private String status;
    private String nome;
    //cosntrutores
    public FormaDePagamento(){

    }
    public FormaDePagamento(int idPagamento, String status, String nome) {
        setIdPagamento(idPagamento);
        setStatus(status);
        setNome(nome);
    }

    //metodos getters and setters
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        try{
            if (idPagamento> 0 && idPagamento < 1000000000){
                this.idPagamento = idPagamento;
            }else{
                throw new Exception("Informe um ID de Pagamento válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        try{
            if (status.equalsIgnoreCase("Pendente") || status.equalsIgnoreCase("Pago")){
                this.status = status;
            }else {
                throw new Exception("Tipo de status não identificado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        try{
            if (nome.equalsIgnoreCase("Pix") || nome.equalsIgnoreCase("Dinheiro") || nome.equalsIgnoreCase("Débito") || nome.equalsIgnoreCase("Debito") || nome.equalsIgnoreCase("Crédito") || nome.equalsIgnoreCase("Credito")){
                this.nome = nome;
            }else {
                throw new Exception("Tipo de Pagamento não identificado, aceitamos Pix, Dinheiro, cartão de Débito ou Crédito");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodos particulares
    public void atualizarStatus() {
        String novoStatus = JOptionPane.showInputDialog("Digite o novo Status de confirmção: ");
        while (!novoStatus.equalsIgnoreCase("Pendente") && !novoStatus.equalsIgnoreCase("Pago")) {
            novoStatus = JOptionPane.showInputDialog("Digite o novo Status de confirmção: ");
        }
        this.status = novoStatus;
        JOptionPane.showMessageDialog(null, String.format("Status atualizado para: %s ", status), "Pagamento", JOptionPane.INFORMATION_MESSAGE);
    }

    public void exibirPagamento(){
        JOptionPane.showMessageDialog(null, String.format("=== Pagamento === \nForma de Pagamento: %s \nStatus: %s \nId Pagamento: %d", getNome(), getStatus(), getIdPagamento()), "Pagamento", JOptionPane.INFORMATION_MESSAGE);
    }
}
