package br.com.fiap.projeto_musica.dto;

import br.com.fiap.projeto_musica.model.Banda;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(description = "Classe que representa DTO da entidade Banda")
@Data
@NoArgsConstructor
public class BandaDTO  {

    @Schema(description = "Atributo de indenticacao da Banda", example="1")
    private Long id;
    @Schema(description = "Atributo do nome da Banda ", example="Bruno Mars")
    private String nome;
    @Schema(description = "Atributo de data de fundação de Banda", example = "10/08/1980")
    private LocalDate dataFundacao;
    @Schema(description = "Atributo do pais de origem da banda", example = "Brasil")
    private String paisOrigem;
    @Schema(description = "Atributo que indica se a banda está ativa ou não (True or False)", example = "True")
    private Boolean ativa;

    public BandaDTO(String nome, LocalDate dataFundacao, String paisOrigem, Boolean ativa){
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.paisOrigem = paisOrigem;
        this.ativa = ativa;
    }

    public BandaDTO(Banda banda){
        this.id = banda.getId();
        this.nome = banda.getNome();
        this.dataFundacao = banda.getDataFundacao();
        this.paisOrigem = banda.getPaisOrigem();
        this.ativa = banda.getAtiva();
    }
}
