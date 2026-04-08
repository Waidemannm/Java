package br.com.fiap.projeto_musica.dto;

import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.model.Integrante;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class IntegrandeDTO extends RepresentationModel<IntegrandeDTO> {

    private Banda banda;
    private String nome;
    private LocalDate dataNascimento;
    private String funcao;

    public IntegrandeDTO(Banda banda, String nome, LocalDate dataNascimento, String funcao){
        this.banda = banda;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.funcao = funcao;
    }

    public IntegrandeDTO(Integrante integrante){
        this.banda = integrante.getBanda();
        this.nome = integrante.getNome();
        this.dataNascimento = integrante.getDataNascimento();
        this.funcao = integrante.getFuncao();
    }
}
