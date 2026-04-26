package br.com.fiap.projeto_musica.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.projeto_musica.dto.MusicaDTO;
import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.projection.MusicaProjection;
import br.com.fiap.projeto_musica.repository.MusicaRepository;
import br.com.fiap.projeto_musica.service.MusicaCachingService;
import br.com.fiap.projeto_musica.service.MusicaPaginacaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/musicas")
public class MusicaController {

    @Autowired
    private MusicaRepository musicaRepository;

    @Autowired
    private MusicaPaginacaoService musicaPaginacaoService;

    @Autowired
    private MusicaCachingService musicaCachingService;

    @Operation(description= "Este endpoint retorna páginas de MusicasDTO com base nos dados page e size", summary = "Retorna páginas de MusicasDTO",
            tags = "Retorno de Informações")
    @GetMapping(value = "/paginados")
    public ResponseEntity<Page<MusicaDTO>> paginar(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "2") Integer size){
        PageRequest req = PageRequest.of(page,size);
        Page<MusicaDTO> paginadas = musicaPaginacaoService.paginar(req);
        return ResponseEntity.ok(paginadas);
    }

    @Operation(description = "Este endpoint retorna apenas parte de uma música. O que é interessante para o usuário", summary = "Retorno Lista de MusicaProjection", tags = "Retorno de Informação")
    @GetMapping(value = "/substring")
    public List<MusicaProjection>
    retornarMusicasPorSubstring(@RequestParam String substring){
        return musicaCachingService.findMusicaBySubstring(substring);

    }

    @Operation(description = "Retorna todas as músicas do caching.", summary = "Retorno Lista de Musicas", tags = "Retorno de Informação")
    @GetMapping(value = "/todas_caching")
    public List<Musica> retornarTodasMusicasCaching() {
        return musicaCachingService.findAll();
    }

    @Operation(description = "Retorna todas as musicas do repository", summary = "Retorna Lista de Musicas", tags = "Retorno de Informação")
    @GetMapping(value = "/todas")
    public List<Musica> retornarTodasMusicas() {

        return musicaRepository.findAll();
    }

    @Operation(description = "Retornar uma Musica pelo Id", summary = "Retorna Musica", tags = "Retorno de Informação")
    @GetMapping(value = "/{id}")
    public Musica retornarMusicaPorID(@PathVariable Long id) {

        Optional<Musica> op = musicaCachingService.findById(id);

        if (op.isPresent()) {

            return op.get();

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(description = "Retorna uma Musica por duração de forma otimizada", summary = "Retorna Lista de Musicas", tags = "Retorno de Informação")
    @GetMapping(value = "/por_duracao_otimizado")
    public List<Musica> retornarMusicasPorDuracaoOtimizado(@RequestParam Double duracao){
        return  musicaCachingService.findMusicByDuration(duracao);
    }

    @Operation(description = "Retorna uma Musica por duração", summary = "Retorna Lista de Musicas", tags = "Retorno de Informação")
    @GetMapping(value = "/por_duracao")
    public List<Musica> retornarMusicasPorDuracao(@RequestParam Double duracao) {

        List<Musica> todas = musicaCachingService.findAll();
        List<Musica> retorno = new ArrayList<Musica>();

        todas.forEach(musica -> {
            if(musica.getDuracao() <= duracao) {
                retorno.add(musica);
            }
        });

        return retorno;

    }

    @Operation(description = "Endpoint de Inserir uma nova Musica", summary = "Inserir Musica", tags = "Inserção")
    @PostMapping(value = "/novo")
    public Musica inserirMusica(@RequestBody @Valid Musica musica) {
        musicaRepository.save(musica);
        musicaCachingService.removerCache();

        return musica;
    }

    @Operation(description = "Endpoint para deletar uma Musica", summary = "Deletar Musica", tags = "Deleção")
    @DeleteMapping(value = "/remover/{id}")
    public Musica removerMusica(@PathVariable Long id) {

        Optional<Musica> op = musicaRepository.findById(id);

        if (op.isPresent()) {
            musicaRepository.delete(op.get());
            musicaCachingService.removerCache();
            return op.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Operation(description = "Endpoint para atualização de uma Musica por Id", summary = "Atualização de Musica", tags = "Atualização")
    @PutMapping(value = "/atualizar/{id}")
    public Musica atualizarMusica(@PathVariable Long id, @RequestBody @Valid Musica musica) {

        Optional<Musica> op = musicaRepository.findById(id);

        if (op.isPresent()) {
            Musica musicaBanco = op.get();
            musicaBanco.transferirMusica(musica);
            musicaRepository.save(musicaBanco);
            musicaCachingService.removerCache();
            return musicaBanco;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}