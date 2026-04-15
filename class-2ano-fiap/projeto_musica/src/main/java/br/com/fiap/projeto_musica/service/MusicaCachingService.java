package br.com.fiap.projeto_musica.service;

import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.projection.MusicaProjection;
import br.com.fiap.projeto_musica.repository.MusicaRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaCachingService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Cacheable(value = "retornarMusicasPaginadas", key = "#pr")
    public Page<Musica> findAll(PageRequest pr){
        return musicaRepository.findAll(pr);
    }

    @Cacheable(value = "retornarMusicasPorSubstring", key = "#substring")
    public List<MusicaProjection> findMusicaBySubstring(String substring){
        return musicaRepository.findMusicaBySubstring(substring);
    }

    @Cacheable(value = "retornarTodasMusicas")
    public List<Musica> findAll() {
        return musicaRepository.findAll();
    }

    @Cacheable(value = "retornarMusicaPorID", key = "#id")
    public Optional<Musica> findById(Long id) {
        return musicaRepository.findById(id);
    }

    @Cacheable(value = "retornarMusicasPorDuracao", key = "#duracao")
    public List<Musica> findMusicByDuration(Double duracao){
        return musicaRepository.findMusicByDuration(duracao);
    }

    @CacheEvict(value = {"retornarMusicasPorDuracao",
            "retornarMusicaPorID","retornarTodasMusicas",
            "retornarMusicasPorSubstring",
            "retornarMusicasPaginadas"}, allEntries = true)
    public void removerCache() {
        System.out.println("Removendo cache!");
    }

}
