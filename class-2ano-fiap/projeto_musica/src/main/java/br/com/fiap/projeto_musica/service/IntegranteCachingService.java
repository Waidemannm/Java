package br.com.fiap.projeto_musica.service;

import br.com.fiap.projeto_musica.dto.IntegranteDTO;
import br.com.fiap.projeto_musica.model.Integrante;
import br.com.fiap.projeto_musica.projection.IntegranteProjection;
import br.com.fiap.projeto_musica.repository.IntegranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegranteCachingService {

    @Autowired
    private IntegranteRepository integranteRepository;

    @Cacheable(value = "retornarIntegrantesPaginados", key = "#pr")
    public Page<Integrante> findAll(PageRequest pr){
        return integranteRepository.findAll(pr);
    }

    @Cacheable(value = "retornarTodosIntegrantes")
    public List<Integrante> findAll(){
        return integranteRepository.findAll();
    }

    @Cacheable(value = "retornarIntegrantePorId", key = "#id")
    public Optional<Integrante> findById(Long id){
        return integranteRepository.findById(id);
    }

    @Cacheable(value = "retornarIntegrantePorNome", key = "#nome")
    public List<IntegranteDTO> findIntegranteByName(String nome){
        return  integranteRepository.findIntegranteByName(nome);
    }

    @Cacheable(value = "retornarIntegrantePorSubstring", key = "#string")
    public List<IntegranteProjection> findIntegranteBySubstring(String string){
        return integranteRepository.findIntegranteBySubstring(string);
    }

    @CacheEvict(value = {
            "retornarIntegrantesPaginados",
            "retornarTodosIntegrantes",
            "retornarIntegrantePorId",
            "retornarIntegrantePorNome",
            "retornarIntegrantePorSubstring"
    }, allEntries = true)
    public void removerCache(){
        System.out.println("Removendo Cache!");
    }
}
