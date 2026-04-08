package br.com.fiap.projeto_musica.projection;

import java.time.LocalDate;

public interface BandaProjection {
    public String getBandaNome();
    public LocalDate getDataFundacao();
    public String getPaisOrigem();
}
