package br.com.fiap.projeto_musica.repository;

import br.com.fiap.projeto_musica.model.Integrante;
import br.com.fiap.projeto_musica.projection.IntegranteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IntegranteRepository extends JpaRepository<Integrante, Long> {

    @Query("from Integrante inte where upper(inte.nome) like upper(concat('%', :nome, '%'))")
    public List<Integrante> findIntegranteByName(String nome);


    @Query(nativeQuery = true,
            value = "select distinct " +
                    "inte.NM_INTEGRANTE as integranteNome, " +
                    "band.NM_BANDA as bandaNome, " +
                    "inte.NM_FUNCAO as integranteFuncao " +
                    "from T_INTEGRANTE inte " +
                    "inner join T_BANDA band " +
                    "on (inte.FK_BANDA = band.ID_BANDA) " +
                    "where " +
                    "(upper(inte.NM_INTEGRANTE) like upper(concat('%',:substring,'%'))) or " +
                    "(upper(band.NM_BANDA) like upper(concat('%',:substring,'%'))) or " +
                    "(upper(inte.NM_FUNCAO) like upper(concat('%',:substring,'%'))) " +
                    "order by inte.NM_INTEGRANTE asc")
    public List<IntegranteProjection> findIntegranteBySubstring(String substring);
}
