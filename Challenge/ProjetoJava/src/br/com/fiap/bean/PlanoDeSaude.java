package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Period;

public class PlanoDeSaude {
    //atributos
    private int idPlano;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String nomePlano;
    //cosntrutores
    public PlanoDeSaude(){

    }

    public PlanoDeSaude(int idPlano, LocalDate dataInicio, LocalDate dataTermino, String nomePlano) {
        setIdPlano(idPlano);
        setDataInicio(dataInicio);
        setDataTermino(dataTermino);
        this.nomePlano = nomePlano;
    }

    //metodos getters and setters
    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        try{
            if (idPlano> 0 && idPlano < 1000000000){
                this.idPlano = idPlano;
            }else{
                throw new Exception("Informe um ID de Plano válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        LocalDate dataAtual = LocalDate.now().plusDays(1);
        try{
            if (dataInicio.isBefore(dataAtual)){
                this.dataInicio = dataInicio;
            }else {
                throw new Exception("A data de início não deve ser no futuro!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        LocalDate dataAtual = LocalDate.now().plusDays(1);
        try{
            if (dataTermino.isAfter(dataAtual)){
                this.dataTermino = dataTermino;
            }else {
                throw new Exception("A data de término não deve ser no passado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    //metodos particulares
    public void verificarPlanoAtivo(){
        if (dataInicio.isBefore(dataTermino)){
            JOptionPane.showMessageDialog(null, "O plano está ativo.", "Plano", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "O plano está inativo.", "Plano", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public Period diasRestantes(){
        return Period.between(dataInicio, dataTermino);
    }
}
