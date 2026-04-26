package br.com.fiap.projeto_musica.dto;

import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.model.Integrante;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(description = "Classe que representa DTO da entidade Integrante")
@Data
@NoArgsConstructor
public class IntegranteDTO  {

    @Schema(description = "Atributo de indenticacao do Integrante", example="1")
    private Long id;
    @Schema(description = "Atributo de nome da Banda", example = "Bruno Mars")
    private Banda banda;
    @Schema(description = "Atributo do nome do Integrante", example = "Bruno")
    private String nome;
    @Schema(description = "Atributo da data de nascimento do integrante", example = "11/12/2000")
    private LocalDate dataNascimento;
    @Schema(description = "Atributo da função do integrante na banda",example = "Guitarrista")
    private String funcao;

    public IntegranteDTO(Banda banda, String nome, LocalDate dataNascimento, String funcao){
        this.banda = banda;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.funcao = funcao;
    }

    public IntegranteDTO(Integrante integrante){
        this.id = integrante.getId();
        this.banda = integrante.getBanda();
        this.nome = integrante.getNome();
        this.dataNascimento = integrante.getDataNascimento();
        this.funcao = integrante.getFuncao();
    }
}
