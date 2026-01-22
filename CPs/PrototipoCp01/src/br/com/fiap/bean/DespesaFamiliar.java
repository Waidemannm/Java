// Moisés Waidemann Molinillo Júnior rm563719
package br.com.fiap.bean;

public class DespesaFamiliar {
    public double rendaFamiliar;
    public int numeroDeMoradores;
    public double gastoComLuz;
    public double gastoComAgua;
    public double gastoComIternet;
    public double valorMensalidadeDaAcademia;

    public double calcularTotalDeDespesas(){
        double totalDeDespesa = rendaFamiliar - gastoComAgua - gastoComIternet - gastoComLuz -
                (valorMensalidadeDaAcademia * numeroDeMoradores);
        return totalDeDespesa;
    }
    public double calcularRendaFamiliarLiquida(){
        double valorRestanteLiquido = rendaFamiliar - calcularTotalDeDespesas();
        return valorRestanteLiquido;
    }
}
