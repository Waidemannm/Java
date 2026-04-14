package br.com.fiap.projeto_musica.control;

import br.com.fiap.projeto_musica.dto.BandaDTO;
import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.projection.BandaProjection;
import br.com.fiap.projeto_musica.repository.BandaRepository;
import br.com.fiap.projeto_musica.service.BandaCachingService;
import br.com.fiap.projeto_musica.service.BandaPaginacaoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/bandas")
public class BandaController {

    @Autowired
    private BandaRepository bandaRepository;

    @Autowired
    private BandaCachingService bandaCachingService;

    @Autowired
    private BandaPaginacaoService bandaPaginacaoService;

    @GetMapping(value = "/por_nome")
    public List<Banda> retornarBandasPorNome(@RequestParam String nome){
        List<Banda> todas = bandaCachingService.findAll();
        List<Banda> retorno = new ArrayList<Banda>();
        todas.forEach(banda -> {
            if (banda.getNome().equalsIgnoreCase(nome))
            {
                banda.add(linkTo(methodOn(BandaController.class)
                        .retornarTodasBandas())
                        .withRel("Gostaria de acessar o endpoint que retorna todas as bandas? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class)
                        .retornarBandasPorSubstring(null))
                        .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class).atualizarBanda(banda.getId(), null))
                        .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ banda.getId() + "? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class).paginar(null, null))
                        .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNomeOtimizado(null))
                        .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (otimizado)? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(banda.getId()))
                        .withRel("Gostaria de acessar o endpoint que retorna banda por id? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                        .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class)
                        .inserirBanda(null))
                        .withRel("Gostaria de inserir uma banda? Clique aqui!"));

                banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                        .withRel("Gostaria de acessar o endpoint de bandas caching?  Clique aqui!"));
                retorno.add(banda);
            }
        });
        return retorno;
    }

    @GetMapping(value = "/por_nome_otimizado")
    public List<BandaDTO> retornarBandasPorNomeOtimizado(@RequestParam String nome){
        List<BandaDTO> bandasOtimizados = bandaCachingService.findBandaByName(nome);
        bandasOtimizados.forEach(banda -> {
            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarTodasBandas())
                    .withRel("Gostaria de acessar o endpoint que retorna todas as bandas? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).atualizarBanda(banda.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ banda.getId() + "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(banda.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna banda por id? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                    .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .inserirBanda(null))
                    .withRel("Gostaria de inserir uma banda? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                    .withRel("Gostaria de acessar o endpoint de bandas caching?  Clique aqui!"));
        });
        return bandasOtimizados;
    }

    @GetMapping(value = "/substring")
    public List<BandaProjection>retornarBandasPorSubstring(@RequestParam String substring){
        return bandaCachingService.findBandaBySubstring(substring);
    }

    @GetMapping(value = "/todas")
    public List<Banda> retornarTodasBandas(){
        List<Banda> bandas = bandaRepository.findAll();
        bandas.forEach(banda -> {
            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (OTIMIZADO)? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).atualizarBanda(banda.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ banda.getId() + "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(banda.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna banda por id? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                    .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .inserirBanda(null))
                    .withRel("Gostaria de inserir uma banda? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                    .withRel("Gostaria de acessar o endpoint de bandas caching?  Clique aqui!"));
        });
        return bandas;
    }

    @GetMapping(value = "/todas_caching")
    public List<Banda>retornarTodasBandasCaching(){
        List<Banda> bandasCaching = bandaCachingService.findAll();
        bandasCaching.forEach(banda -> {
            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (OTIMIZADO)? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).atualizarBanda(banda.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ banda.getId() + "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(banda.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna banda por id? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                    .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .inserirBanda(null))
                    .withRel("Gostaria de inserir uma banda? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandas())
                    .withRel("Gostaria de acessar o endpoint de todas as bandas?  Clique aqui!"));
        });
        return bandasCaching;
    }


    @GetMapping(value = "/{id}")
    public Banda retornarBandaPorID(@PathVariable Long id){
        Optional<Banda> op = bandaRepository.findById(id);
        if (op.isPresent()){
            Banda banda = op.get();
            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (OTIMIZADO)? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).atualizarBanda(banda.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ banda.getId() + "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por caching? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                    .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .inserirBanda(null))
                    .withRel("Gostaria de inserir uma banda? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandas())
                    .withRel("Gostaria de acessar o endpoint de todas as bandas?  Clique aqui!"));
            return banda;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/remover/{id}")
    public Banda removerBanda(@PathVariable Long id){
        Optional<Banda> op = bandaRepository.findById(id);
        if (op.isPresent()){
            Banda bandaDeletada = op.get();
            bandaRepository.delete(bandaDeletada);
            bandaDeletada.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (OTIMIZADO)? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class).atualizarBanda(bandaDeletada.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ bandaDeletada.getId() + "? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por caching? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(bandaDeletada.getId()))
                    .withRel("Gostaria de remover a banda de id: " + bandaDeletada.getId()+ "? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class)
                    .inserirBanda(null))
                    .withRel("Gostaria de inserir uma banda? Clique aqui!"));

            bandaDeletada.add(linkTo(methodOn(BandaController.class).retornarTodasBandas())
                    .withRel("Gostaria de acessar o endpoint de todas as bandas?  Clique aqui!"));
            return bandaDeletada;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/paginadas")
    public ResponseEntity<Page<BandaDTO>> paginar(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "2") Integer size){
        PageRequest req = PageRequest.of(page, size);
        Page<BandaDTO> paginadas = bandaPaginacaoService.paginar(req);
        paginadas.forEach(banda -> {
            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (OTIMIZADO)? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).atualizarBanda(banda.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ banda.getId() + "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(banda.getId()))
                    .withRel("Gostaria de acessar o endpoint de retornar banda de id: "+ banda.getId() +"? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por caching? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                    .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .inserirBanda(null))
                    .withRel("Gostaria de inserir uma banda? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandas())
                    .withRel("Gostaria de acessar o endpoint de todas as bandas?  Clique aqui!"));
        });
        return ResponseEntity.ok(paginadas);
    }

    @PostMapping(value = "/nova")
    public Banda inserirBanda(@RequestBody @Valid Banda banda){
        bandaRepository.save(banda);
        bandaCachingService.removerCache();
        banda.add(linkTo(methodOn(BandaController.class)
                .retornarBandasPorNomeOtimizado(null))
                .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (OTIMIZADO)? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class)
                .retornarBandasPorSubstring(null))
                .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class).atualizarBanda(banda.getId(), null))
                .withRel("Gostaria de acessar o endpoint que atualiza a banda de Id: "+ banda.getId() + "? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(banda.getId()))
                .withRel("Gostaria de acessar o endpoint de retornar banda de id: "+ banda.getId() +"? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                .withRel("Gostaria de acessar o endpoint que retorna bandas por caching? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class)
                .paginar(null, null))
                .withRel("Gostaria de paginar o retorno de bandas? Clique aqui!"));

        banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandas())
                .withRel("Gostaria de acessar o endpoint de todas as bandas?  Clique aqui!"));
        return banda;
    }

    @PutMapping(value = "/atualizar/{id}")
    public Banda atualizarBanda(@PathVariable Long id, @RequestBody @Valid Banda banda){
        Optional<Banda> op = bandaRepository.findById(id);
        if (op.isPresent()){
            Banda bandaBanco = op.get();
            bandaBanco.transferirBanda(banda);
            bandaRepository.save(bandaBanco);
            bandaCachingService.removerCache();
            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome (OTIMIZADO)? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .retornarBandasPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).inserirBanda( null))
                    .withRel("Gostaria de acessar o endpoint que adiciona uma banda? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandaPorID(banda.getId()))
                    .withRel("Gostaria de acessar o endpoint de retornar banda de id: "+ banda.getId() +"? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarBandasPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por nome? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandasCaching())
                    .withRel("Gostaria de acessar o endpoint que retorna bandas por caching? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).removerBanda(banda.getId()))
                    .withRel("Gostaria de remover a banda de id: " + banda.getId()+ "? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class)
                    .paginar(null, null))
                    .withRel("Gostaria de paginar o retorno de bandas? Clique aqui!"));

            banda.add(linkTo(methodOn(BandaController.class).retornarTodasBandas())
                    .withRel("Gostaria de acessar o endpoint de todas as bandas?  Clique aqui!"));
            return bandaBanco;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }
}
