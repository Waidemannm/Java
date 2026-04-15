package br.com.fiap.projeto_musica.repository;

import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.projection.MusicaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

    @Query("from Musica mus where mus.duracao <= :duracao")
    public List<Musica> findMusicByDuration(Double duracao);

    @Query(nativeQuery = true,
            value = "select distinct " +
                    "mus.NM_MUSICA as musicaTitulo, " +
                    "band.NM_BANDA as bandaNome, " +
                    "mus.VL_DURACAO as musicaDuracao " +
                    "from T_MUSICA mus " +
                    "inner join T_BANDA band " +
                    "on (mus.FK_BANDA = band.ID_BANDA) " +
                    "inner join T_INTEGRANTE inte " +
                    "on (inte.FK_BANDA = band.ID_BANDA) " +
                    "where " +
                    "(upper(mus.NM_MUSICA) like upper(concat('%',:substring,'%'))) " +
                    "or (upper(band.NM_BANDA) like upper(concat('%',:substring,'%'))) " +
                    "or (upper(inte.NM_INTEGRANTE) like upper(concat('%',:substring,'%'))) " +
                    "order by mus.NM_MUSICA asc")
    public List<MusicaProjection> findMusicaBySubstring(String substring);
}
