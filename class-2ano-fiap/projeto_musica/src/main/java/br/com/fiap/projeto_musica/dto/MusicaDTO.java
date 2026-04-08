package br.com.fiap.projeto_musica.dto;

import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.model.GeneroEnum;
import br.com.fiap.projeto_musica.model.Musica;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@Data
public class MusicaDTO extends RepresentationModel<MusicaDTO> {

    private Banda banda;
    private GeneroEnum genero;
    private String titulo;
    private Double duracao;

    public MusicaDTO(Banda banda, GeneroEnum genero, String titulo, Double duracao) {
        this.banda = banda;
        this.genero = genero;
        this.titulo = titulo;
        this.duracao = duracao;
    }

    public MusicaDTO(Musica musica) {
        this.banda = musica.getBanda();
        this.genero = musica.getGenero();
        this.titulo = musica.getTitulo();
        this.duracao = musica.getDuracao();
    }
}
