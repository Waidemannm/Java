package br.com.fiap.projeto_musica.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Entidade que representa a tabela de Musica no DB")
@Entity
@Table(name = "T_MUSICA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUSICA")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "FK_BANDA")
    private Banda banda;
    @Enumerated(EnumType.STRING)
    @Column(name = "NM_GENERO")
    private GeneroEnum genero;
    @NotEmpty(message = "O título é um campo obrigatório")
    @Size(min = 1, max = 50, message = "O tamanho mínimo do titulo deve ser de 1 caracter ou máximo de 50 caracteres")
    @Column(name = "NM_MUSICA")
    private String titulo;
    @DecimalMax(value = "60.0", message = "Tempo máximo de uma música é 60min.")
    @DecimalMin(value = "0.01", message = "Tempo mínimo de uma música é 60min.")
    @Column(name = "VL_DURACAO")
    private Double duracao;

    public void transferirMusica(Musica musica) {
        this.banda = musica.getBanda();
        this.genero = musica.getGenero();
        this.titulo = musica.getTitulo();
        this.duracao = musica.getDuracao();
    }
}
