package br.com.fiap.bean;

import javax.swing.*;

public class LogMensagem {
    //atributos
    private int idLog;
    private String mensagem;
    private String status;
    //cosntrutores
    public LogMensagem(){

    }
    public LogMensagem(int idLog, String mensagem, String status) {
        setIdLog(idLog);
        this.mensagem = mensagem;
        this.status = status;
    }
    //metodos getters and setters

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        try{
            if (idLog > 0 && idLog < 1000000000){
                this.idLog = idLog;
            }else{
                throw new Exception("Informe um ID de Log válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        try{
            if (mensagem != null){
                this.mensagem = mensagem;
            }else {
                throw new Exception("Digite uma mensagem!");
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
            if (status.equalsIgnoreCase("Entregue") || status.equalsIgnoreCase("Lido") || status.equalsIgnoreCase("Enviado") || status.equalsIgnoreCase("Respondido")){
                this.status = status;
            }else {
                throw new Exception("Tipo de status não identificado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodos particulares
    public void exibirLog(){
        if (mensagem != null){
            JOptionPane.showMessageDialog(null, String.format("=== Log de Mensagem === \nId Mensagem: %d \nMensagem: %s \nStatus: %s ", getIdLog(), getMensagem(), getStatus()));
        } else{
            JOptionPane.showMessageDialog(null, "Não há mensagem registrada!", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void atualizarStatus(){
        String novoStatus = JOptionPane.showInputDialog("Digite o novo Status da mensagem: ");

        while (!novoStatus.equalsIgnoreCase("Entregue") && !novoStatus.equalsIgnoreCase("Lido") &&  !novoStatus.equalsIgnoreCase("Enviado") && !novoStatus.equalsIgnoreCase("Respondido")){
            novoStatus = JOptionPane.showInputDialog("Status inválido, Digito um status válido(Entregue, Lido, Enviado ou Respondido): ");
        }
        this.status = novoStatus;
        JOptionPane.showMessageDialog(null, String.format("Status atualizado para: %s ", status), "Pagamento", JOptionPane.INFORMATION_MESSAGE);
        }
    }