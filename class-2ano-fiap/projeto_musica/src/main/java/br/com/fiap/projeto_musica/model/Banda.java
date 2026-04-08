package br.com.fiap.projeto_musica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Entity
@Table(name = "T_BANDA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Banda extends RepresentationModel<Banda> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BANDA")
    private Long id;
    @NotEmpty(message = "É necessário um nome para banda")
    @Column(name = "NM_BANDA")
    @Size(min = 1, max = 50, message = "O tamanho mínimo do nome da banda deve ser de 1 caracter ou máximo de 50 caracteres")
    private String nome;
    @PastOrPresent(message = "A data de função deve ser a data atual ou no passado.")
    @Column(name = "DT_FUNDACAO")
    private LocalDate dataFundacao;
    @Column(name = "NM_PAIS")
    @Size(min = 1, max = 50, message = "O tamanho mínimo do nome da banda deve ser de 1 caracter ou máximo de 50 caracteres")
    private String paisOrigem;
    private Boolean ativa;
}
