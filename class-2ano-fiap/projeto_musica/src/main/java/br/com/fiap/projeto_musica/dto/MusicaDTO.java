package br.com.fiap.projeto_musica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.model.GeneroEnum;
import br.com.fiap.projeto_musica.model.Musica;

@Schema(description = "Classe que representa DTO da entidade Musica")
@Data
@NoArgsConstructor
public class MusicaDTO  {

    @Schema(description = "Atributo de indenticacao da Musica", example="1")
    private Long id;
    @Schema(description = "Atributo de nome da Banda", example = "Bruno Mars")
    private Banda banda;
    @Schema(description = "Atributo do genero da Musica", example = "Rock")
    private GeneroEnum genero;
    @Schema(description = "Atributo do Titulo da Musica", example = "Run To the Hills")
    private String titulo;
    @Schema(description = "Atributo do tempo de duração da Musica", example = "4.01")
    private Double duracao;

    public MusicaDTO(Banda banda, GeneroEnum genero, String titulo, Double duracao) {
        super();
        this.banda = banda;
        this.genero = genero;
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public MusicaDTO(Musica musica) {
        this.id = musica.getId();
        this.banda = musica.getBanda();
        this.genero = musica.getGenero();
        this.titulo = musica.getTitulo();
        this.duracao = musica.getDuracao();
    }


}
