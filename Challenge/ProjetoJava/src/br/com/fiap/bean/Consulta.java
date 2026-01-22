package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Consulta {
    //atributos
    private int idConsulta;
    private LocalDate dataConsulta;
    private LocalTime horario;
    //cosntrutores
    public Consulta(){

    }

    public Consulta(int idConsulta, LocalTime horario, LocalDate dataConsulta) {
        setIdConsulta(idConsulta);
        setHorario(horario);
        setDataConsulta(dataConsulta);
    }
    //metodos getters and setters

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        try{
            if (idConsulta > 0 && idConsulta < 1000000000){
                this.idConsulta = idConsulta;
            }else{
                throw new Exception("Informe um ID de Consulta válido!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        LocalDate dataAtual = LocalDate.now();
        try{
            if (dataConsulta.isBefore(dataAtual)){
                this.dataConsulta = dataConsulta;
            }else{
                throw new Exception("Data não deve ser no passado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        LocalTime inicio = LocalTime.parse("08:00");
        LocalTime fim= LocalTime.parse("16:00");
        try {
            if (horario.isAfter(inicio) && horario.isBefore(fim)){
                this.horario = horario;
            }else {
                throw new Exception("Horário de consultas: Das 08h ás 16h.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }
    //metodos particulares
    public Period diasParaConsulta() {
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataAtual, getDataConsulta());
    }
    public boolean consultaFutura(){
        LocalDate dataAtual = LocalDate.now();
        if (dataConsulta == null){
            return false;
        }
        return dataConsulta.isAfter(dataAtual);
    }
}
