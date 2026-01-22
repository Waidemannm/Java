package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;

public class Confirmacao {
    //atributos
    private int idConfirmacao;
    private LocalDate dataConfirmacao;
    private String status;
    //cosntrutores
    public Confirmacao(){

    }
    public Confirmacao(int idConfirmacao, LocalDate dataConfirmacao, String status) {
        setIdConfirmacao(idConfirmacao);
        setDataConfirmacao(dataConfirmacao);
        setStatus(status);
    }
    //metodos getters and setters

    public int getIdConfirmacao() {
        return idConfirmacao;
    }

    public void setIdConfirmacao(int idConfirmacao) {
        try{
            if (idConfirmacao > 0 && idConfirmacao < 1000000000){
                this.idConfirmacao = idConfirmacao;
            }else{
                throw new Exception("Informe um ID de confirmação válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(LocalDate dataConfirmacao) {
        LocalDate dataAtual = LocalDate.now();
        try{
            if (dataConfirmacao.isBefore(dataAtual)){
                this.dataConfirmacao = dataConfirmacao;
            }else{
                throw new Exception("Data não deve ser no passado!");
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
            if (status.equalsIgnoreCase("Pendente") || status.equalsIgnoreCase("Confirmado") || status.equalsIgnoreCase("Ausente")){
                this.status = status;
            }else {
                throw new Exception("Tipo de status não identificado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodos particulares
    public void verificarConfirmacao() {
        if (status.equalsIgnoreCase("Confirmado")){
            JOptionPane.showMessageDialog(null, "O se status para consulta é: Confirmado", "Status", JOptionPane.INFORMATION_MESSAGE);
        } else if (status.equalsIgnoreCase("Pendente")) {
            JOptionPane.showMessageDialog(null, "O se status para consulta é: Pendente","Status", JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "O se status para consulta é: Ausente", "Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void atualizarStatus(){
        String novoStatus = JOptionPane.showInputDialog("Digite o novo Status de confirmção: ");
        while (!novoStatus.equalsIgnoreCase("Pendente") && !novoStatus.equalsIgnoreCase("Confirmado") &&  !novoStatus.equalsIgnoreCase("Ausente")){
            novoStatus = JOptionPane.showInputDialog("Digite o novo Status de confirmção: ");
        }
        this.status = novoStatus;
        JOptionPane.showMessageDialog(null, String.format("Status atualizado para: %s", status), "Confirmação", JOptionPane.INFORMATION_MESSAGE);
    }
}
