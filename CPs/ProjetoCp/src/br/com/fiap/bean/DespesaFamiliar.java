//Gabriel Sbrana Campos, rm565849
//Moisés Waidemann, rm563719
package br.com.fiap.bean;


public class DespesaFamiliar {
    //Atríbutos
    public double rendaFamiliar;
    public int numeroDeMoradores;
    public double gastoComLuz;
    public double gastoComAgua;
    public double gastoComInternet;
    public double valorMensalidadeDaAcademia;

    //Métodos
    public double calcularTotalDeDespensas(){
        double despensas = gastoComLuz + gastoComAgua +
                gastoComInternet + (numeroDeMoradores * valorMensalidadeDaAcademia);
        return despensas;
    }
    public double calcularRendaFamiliarLiquida(){
        double restanteRenda = rendaFamiliar - calcularTotalDeDespensas();
        return restanteRenda;
    }

}