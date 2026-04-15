package br.com.fiap.projeto_musica.service;

import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.projection.BandaProjection;
import br.com.fiap.projeto_musica.repository.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BandaCachingService {

    @Autowired
    private BandaRepository bandaRepository;

    @Cacheable(value = "retornarBandasPaginadas", key = "#pr")
    public Page<Banda> findAll(PageRequest pr){
        return bandaRepository.findAll(pr);
    }

    @Cacheable(value = "retornarTodasBandas")
    public List<Banda> findAll(){
        return bandaRepository.findAll();
    }

    @Cacheable(value = "retornarBandaPorId",key = "#id")
    public Optional<Banda> findById(Long id){
        return bandaRepository.findById(id);
    }

    @Cacheable(value = "retornarBandaPorNome", key = "#nome")
    public List<Banda> findBandaByName(String nome){
        return  bandaRepository.findBandaByName(nome);
    }

    @Cacheable(value = "retornarIntegrantePorSubstring", key = "#string")
    public List<BandaProjection> findBandaBySubstring(String string){
        return bandaRepository.findBandaBySubstring(string);
    }


    @CacheEvict(value = {
            "retornarBandasPaginadas",
            "retornarTodasBandas",
            "retornarBandaPorId",
            "retornarBandaPorNome",
            "retornarIntegrantePorSubstring"
    }, allEntries = true)
    public void removerCache(){

    }
}
