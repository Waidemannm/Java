package br.com.fiap.projeto_musica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "T_INTEGRANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Integrante {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ID_INTEGRANTE")
    private Long id;
    @ManyToMany
    @JoinColumn(name = "FK_BANDA")
    private Banda banda;
    @Column(name = "DT_NASCIMENTO")
    @PastOrPresent(message = "A data de nascimento deve ser a data atual ou no passado.")
    private LocalDate dataNascimento;
    @Column(name = "NM_FUNCAO")
    @NotEmpty(message = "A função é um campo obrigatório")
    @Size(min = 1, max = 50, message = "O tamanho mínimo da titulo deve ser de 1 caracter ou máximo de 50 caracteres")
    private String funcao;
}
