package br.com.fiap.projeto_musica.dto;

import br.com.fiap.projeto_musica.model.Banda;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BandaDTO extends RepresentationModel<BandaDTO> {

    private String nome;
    private LocalDate dataFundacao;
    private String paisOrigem;
    private Boolean ativa;

    public BandaDTO(String nome, LocalDate dataFundacao, String paisOrigem, Boolean ativa){
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.paisOrigem = paisOrigem;
        this.ativa = ativa;
    }

    public BandaDTO(Banda banda){
        this.nome = banda.getNome();
        this.dataFundacao = banda.getDataFundacao();
        this.paisOrigem = banda.getPaisOrigem();
        this.ativa = banda.getAtiva();
    }
}
