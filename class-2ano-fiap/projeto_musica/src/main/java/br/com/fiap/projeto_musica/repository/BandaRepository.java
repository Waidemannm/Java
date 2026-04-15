package br.com.fiap.projeto_musica.repository;

import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.projection.BandaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BandaRepository extends JpaRepository<Banda, Long> {

    @Query("from Banda band where upper(band.nome) like upper(concat('%', :nome, '%'))")
    public List<Banda> findBandaByName(String nome);

    @Query(nativeQuery = true,
            value = "select distinct " +
                    "band.NM_BANDA as bandaNome, " +
                    "band.NM_PAIS as paisOrigem " +
                    "from T_BANDA band " +
                    "where (upper(band.NM_BANDA) like upper(concat('%',:substring,'%'))) " +
                    "or (upper(band.NM_PAIS) like upper(concat('%',:substring,'%'))) " +
                    "order by band.NM_BANDA asc")
    List<BandaProjection> findBandaBySubstring(String substring);
}