package br.com.fiap.projeto_musica.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "T_BANDA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANDA")
    @Schema(description = "Atributo de indenticacao da Banda", example="1")
    private Long id;
    @NotEmpty(message = "É necessário um nome para banda")
    @Column(name = "NM_BANDA")
    @Size(min = 1, max = 50, message = "O tamanho mínimo do nome da banda deve ser de 1 caracter ou máximo de 50 caracteres")
    @Schema(description = "Atributo do nome da Banda ", example="Bruno Mars")
    private String nome;
    @PastOrPresent(message = "A data de função deve ser a data atual ou no passado.")
    @Column(name = "DT_FUNDACAO")
    @Schema(description = "Atributo de data de fundação de Banda", example = "10/08/1980")
    private LocalDate dataFundacao;
    @Schema(description = "Atributo do pais de origem da banda", example = "Brasil")
    @Column(name = "NM_PAIS")
    @Size(min = 1, max = 50, message = "O tamanho mínimo do nome da banda deve ser de 1 caracter ou máximo de 50 caracteres")
    private String paisOrigem;
    @Schema(description = "Atributo que indica se a banda está ativa ou não (True or False)", example = "True")
    private Boolean ativa;

    public void transferirBanda(Banda banda){
        this.nome = banda.getNome();
        this.dataFundacao = banda.getDataFundacao();
        this.paisOrigem = banda.getPaisOrigem();
        this.ativa = banda.getAtiva();
    }
}
