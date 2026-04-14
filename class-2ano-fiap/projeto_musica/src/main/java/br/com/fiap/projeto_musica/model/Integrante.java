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
@Table(name = "T_INTEGRANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Integrante extends RepresentationModel<Integrante> {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "ID_INTEGRANTE")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "FK_BANDA")
    private Banda banda;
    @NotEmpty(message = "O nome é um campo obrigatório")
    @Column(name = "NM_INTEGRANTE")
    @Size(min = 1, max = 100, message = "O tamanho mínimo dao nome deve ser de 1 caracter ou máximo de 100 caracteres")
    private String nome;
    @Column(name = "DT_NASCIMENTO")
    @PastOrPresent(message = "A data de nascimento deve ser a data atual ou no passado.")
    private LocalDate dataNascimento;
    @Column(name = "NM_FUNCAO")
    @NotEmpty(message = "A função é um campo obrigatório")
    @Size(min = 1, max = 50, message = "O tamanho mínimo da titulo deve ser de 1 caracter ou máximo de 50 caracteres")
    private String funcao;

    public void tranferirIntegrante(Integrante integrante){
        this.banda = integrante.getBanda();
        this.nome = integrante.getNome();
        this.dataNascimento = integrante.getDataNascimento();
        this.funcao = integrante.getFuncao();
    }
}
