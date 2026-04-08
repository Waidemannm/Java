package br.com.fiap.projeto_musica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "musica")
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "fk_banda")
	private Banda banda;
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;
	@NotEmpty(message = "O título é um campo obrigatório")
	@Size(min = 1, max = 50, message = "O tamanho mínimo da string deve "
			+ "ser de 1 caracter e o máximo de 50 caracteres")
	private String titulo;
	@DecimalMax("60.0")
	@DecimalMin("0.01")
	private Double duracao;

	
	public void transferirMusica(Musica musica) {
		this.banda = musica.getBanda();
		this.genero = musica.getGenero();
		this.titulo = musica.getTitulo();
		this.duracao = musica.getDuracao();
	}
}
