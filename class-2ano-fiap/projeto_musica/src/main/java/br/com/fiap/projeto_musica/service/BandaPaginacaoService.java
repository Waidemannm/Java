package br.com.fiap.projeto_musica.service;

import br.com.fiap.projeto_musica.dto.BandaDTO;
import br.com.fiap.projeto_musica.model.Banda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BandaPaginacaoService {

    @Autowired
    private BandaCachingService bandaCachingService;

    public Page<BandaDTO> paginar(PageRequest req){
        Page<Banda> paginasBandas = bandaCachingService.findAll(req);
        Page<BandaDTO> paginasBandasDto = paginasBandas.map(banda -> new BandaDTO(banda));
        return paginasBandasDto;
    }
}
