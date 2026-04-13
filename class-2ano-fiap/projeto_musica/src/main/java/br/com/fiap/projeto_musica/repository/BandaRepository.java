package br.com.fiap.projeto_musica.repository;

import br.com.fiap.projeto_musica.dto.BandaDTO;
import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.projection.BandaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BandaRepository extends JpaRepository<Banda, Long> {

    @Query("from Banda band where band.nome <= :nome")
    public BandaDTO findBandaByName(String nome);

    @Query(nativeQuery = true, value = "select distinct band.NM_BANDA, band.NM_PAIS from T_BANDA band where (upper(band.NM_BANDA) like upper(concat('%',:substring,'%'))) " +
            " or (upper(band.NM_PAIS) like upper(concat('%',:substring,'%'))) " +
            "order by band.NM_BANDA asc")
    public List<BandaProjection> findIntegranteBySubstring(String substring);
}