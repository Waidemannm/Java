package br.com.fiap.projeto_musica.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping(value = "/paginadas")
    public ResponseEntity<Page<MusicaDTO>> paginar(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "2") Integer size){
        PageRequest req = PageRequest.of(page,size);
        Page<MusicaDTO> paginadas = musicaPaginacaoService.paginar(req);

        paginadas.forEach(musica -> {
            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarTodasMusicas())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                            + " Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarMusicasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musica.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por ID?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (otimizado)?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                    .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .atualizarMusica(musica.getId(), null))
                    .withRel("Gostaria de atualizar a música " + musica.getTitulo() + "? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                    .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));
        });

        return ResponseEntity.ok(paginadas);
    }

    @GetMapping(value = "/substring")
    public List<MusicaProjection>
    retornarMusicasPorSubstring(@RequestParam String substring){
        return musicaCachingService.findMusicaBySubstring(substring);

    }

    @GetMapping(value = "/todas_caching")
    public List<Musica> retornarTodasMusicasCaching() {
        List<Musica> musicasCaching = musicaCachingService.findAll();
        musicasCaching.forEach(musica -> {
            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarTodasMusicas())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                            + " Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarMusicasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas paginadas?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musica.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por ID?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (otimizado)?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                    .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .atualizarMusica(musica.getId(), null))
                    .withRel("Gostaria de atualizar a música " + musica.getTitulo() + "? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                    .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));
        });
        return musicasCaching;
    }

    @GetMapping(value = "/todas")
    public List<Musica> retornarTodasMusicas() {

        List<Musica> todas = musicaRepository.findAll();

        todas.forEach( musica -> {
            musica.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de músicas paginadas? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarMusicasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musica.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por ID?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (otimizado)?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                    .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .atualizarMusica(musica.getId(), null))
                    .withRel("Gostaria de atualizar a música " + musica.getTitulo() + "? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                    .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));
        });

        return todas;
    }

    @GetMapping(value = "/{id}")
    public Musica retornarMusicaPorID(@PathVariable Long id) {

        Optional<Musica> op = musicaCachingService.findById(id);

        if (op.isPresent()) {

            Musica musica = op.get();

            musica.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de músicas paginadas? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarMusicasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicas())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (otimizado)?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                    .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .atualizarMusica(musica.getId(), null))
                    .withRel("Gostaria de atualizar a música " + musica.getTitulo() + "? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                    .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));

            return musica;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/por_duracao_otimizado")
    public List<MusicaDTO> retornarMusicasPorDuracaoOtimizado(@RequestParam Double duracao){
        List<MusicaDTO> musicasDuracaoOtimizada = musicaCachingService.findMusicByDuration(duracao);
        musicasDuracaoOtimizada.forEach(musica -> {
            musica.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de músicas paginadas? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarMusicasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicas())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musica.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por id" + musica.getId()
                            + "? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                    .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .atualizarMusica(musica.getId(), null))
                    .withRel("Gostaria de atualizar a música " + musica.getTitulo() + "? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                    .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));
        });
        return musicasDuracaoOtimizada;
    }

    @GetMapping(value = "/por_duracao")
    public List<Musica> retornarMusicasPorDuracao(@RequestParam Double duracao) {

        List<Musica> todas = musicaCachingService.findAll();
        List<Musica> retorno = new ArrayList<Musica>();

        todas.forEach(musica -> {
            if(musica.getDuracao() <= duracao) {
                musica.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                        .withRel("Gostaria de acessar o endpoint de músicas paginadas? Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class)
                        .retornarMusicasPorSubstring(null))
                        .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                        .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                                + "Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicas())
                        .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                                + "Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musica.getId()))
                        .withRel("Gostaria de acessar o endpoint que retorna músicas por id" + musica.getId()
                                + "? Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                        .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (OTIMIZADA)?"
                                + "Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                        .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class)
                        .atualizarMusica(musica.getId(), null))
                        .withRel("Gostaria de atualizar a música " + musica.getTitulo() + "? Clique aqui!"));

                musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                        .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));
                retorno.add(musica);
            }
        });

        return retorno;

    }

    @PostMapping(value = "/nova")
    public Musica inserirMusica(@RequestBody @Valid Musica musica) {
        musicaRepository.save(musica);
        musicaCachingService.removerCache();

        musica.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                .withRel("Gostaria de acessar o endpoint de músicas paginadas? Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class)
                .retornarMusicasPorSubstring(null))
                .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                        + "Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicas())
                .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                        + "Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musica.getId()))
                .withRel("Gostaria de acessar o endpoint que retorna músicas por id" + musica.getId()
                        + "? Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (OTIMIZADA)?"
                        + "Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                .withRel("Gostaria de acessar o endpoint que retorna músicas por duração? Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class)
                .atualizarMusica(musica.getId(), null))
                .withRel("Gostaria de atualizar a música " + musica.getTitulo() + "? Clique aqui!"));

        musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));

        return musica;
    }

    @DeleteMapping(value = "/remover/{id}")
    public Musica removerMusica(@PathVariable Long id) {

        Optional<Musica> op = musicaRepository.findById(id);

        if (op.isPresent()) {
            musicaRepository.delete(op.get());
            musicaCachingService.removerCache();
            Musica musicaDeletada = op.get();
            musicaDeletada.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de músicas paginadas? Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class)
                    .retornarMusicasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                            + "Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicas())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                            + "Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musicaDeletada.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por id" + musicaDeletada.getId()
                            + "? Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (OTIMIZADA)?"
                            + "Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração? Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class)
                    .atualizarMusica(musicaDeletada.getId(), null))
                    .withRel("Gostaria de atualizar a música " + musicaDeletada.getTitulo() + "? Clique aqui!"));

            musicaDeletada.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                    .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

            return musicaDeletada;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping(value = "/atualizar/{id}")
    public Musica atualizarMusica(@PathVariable Long id, @RequestBody @Valid Musica musica) {

        Optional<Musica> op = musicaRepository.findById(id);

        if (op.isPresent()) {
            Musica musica_banco = op.get();
            musica_banco.transferirMusica(musica);
            musicaRepository.save(musica_banco);
            musicaCachingService.removerCache();
            musica.add(linkTo(methodOn(MusicaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de músicas paginadas? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class)
                    .retornarMusicasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas por caching?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarTodasMusicas())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as músicas?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicaPorID(musica.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por id" + musica.getId()
                            + "? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracaoOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração (OTIMIZADA)?"
                            + "Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).retornarMusicasPorDuracao(null))
                    .withRel("Gostaria de acessar o endpoint que retorna músicas por duração? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).inserirMusica(null))
                    .withRel("Gostaria de adicionar uma nova música? Clique aqui!"));

            musica.add(linkTo(methodOn(MusicaController.class).removerMusica(musica.getId()))
                    .withRel("Gostaria de remover a música " + musica.getTitulo() + "? Clique aqui!"));
            return musica_banco;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}