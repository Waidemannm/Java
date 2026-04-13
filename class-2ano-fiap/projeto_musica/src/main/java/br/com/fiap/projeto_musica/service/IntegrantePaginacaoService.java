package br.com.fiap.projeto_musica.service;

import br.com.fiap.projeto_musica.dto.IntegranteDTO;
import br.com.fiap.projeto_musica.model.Integrante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class IntegrantePaginacaoService {

    @Autowired
    private IntegranteCachingService integranteCachingService;

     public Page<IntegranteDTO> paginar(PageRequest req){
        Page<Integrante> paginasIntegrantes = integranteCachingService.findAll(req);
        Page<IntegranteDTO> paginasIntegrantesDto = paginasIntegrantes.map(integrante -> new IntegranteDTO(integrante));
        return paginasIntegrantesDto;
     }
}
