package br.com.fiap.projeto_musica.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.model.GeneroEnum;
import br.com.fiap.projeto_musica.model.Musica;

@Data
@NoArgsConstructor
public class MusicaDTO  {

    private Long id;
    private Banda banda;
    private GeneroEnum genero;
    private String titulo;
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
