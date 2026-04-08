package br.com.fiap.projeto_musica.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.projection.IMusicaProjection;

public interface MusicaRepository extends JpaRepository<Musica,Long>{

	@Query("from Musica m where m.duracao <= :duracao")
	public List<Musica> retornarMuicasPorDuracao(Double duracao);
	
	@Query(nativeQuery = true, value = "")
	public List<IMusicaProjection> retornaMusicasPorSubstring(String substring);
	
}
