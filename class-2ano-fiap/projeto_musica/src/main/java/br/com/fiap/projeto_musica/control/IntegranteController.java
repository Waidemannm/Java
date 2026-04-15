package br.com.fiap.projeto_musica.control;

import br.com.fiap.projeto_musica.dto.IntegranteDTO;
import br.com.fiap.projeto_musica.model.Integrante;
import br.com.fiap.projeto_musica.projection.IntegranteProjection;
import br.com.fiap.projeto_musica.repository.IntegranteRepository;
import br.com.fiap.projeto_musica.service.IntegranteCachingService;
import br.com.fiap.projeto_musica.service.IntegrantePaginacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(value = "/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;
    @Autowired
    private IntegranteCachingService integranteCachingService;
    @Autowired
    private IntegrantePaginacaoService integrantePaginacaoService;

    @GetMapping("/todos")
    public List<Integrante> retornarTodosIntegrantes(){
        List<Integrante> integrantes = integranteRepository.findAll();
        integrantes.forEach(integrante -> {
            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarIntegrantesPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).atualizarIntegrante(integrante.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza o integrante de Id: "+ integrante.getId() + "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integrante.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna integrante por ID? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                    .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .inserirIntegrante(null))
                    .withRel("Gostaria de inserir um integrante? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                    .withRel("Gostaria de acessar o endpoint de integrantes caching? Clique aqui!"));
        });
        return integrantes;
    }

    @GetMapping(value = "/todos_caching")
    public List<Integrante>retornarTodosIntegrantesCaching(){

        List<Integrante> integrantesCaching = integranteCachingService.findAll();
        integrantesCaching.forEach(integrante -> {
            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarIntegrantesPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).atualizarIntegrante(integrante.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza o integrante de Id: "+ integrante.getId() + "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integrante.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna integrante por ID? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                    .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .inserirIntegrante(null))
                    .withRel("Gostaria de inserir um integrante? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantes())
                    .withRel("Gostaria de acessar o endpoint de todos os integrantes? Clique aqui!"));
        });
        return integrantesCaching;
    }


    @GetMapping(value = "/substring")
    public List<IntegranteProjection> retornarIntegrantesPorSubstring(@RequestParam String substring){
        return integranteCachingService.findIntegranteBySubstring(substring);
    }

    @GetMapping(value =  "/{id}")
    public Integrante retornarIntegrantePorID(@PathVariable Long id){
        Optional<Integrante> op = integranteCachingService.findById(id);
        if (op.isPresent()){
            Integrante integrante = op.get();
            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarTodosIntegrantes())
                    .withRel("Gostaria de acessar o endpoint que retorna todas os integrantes? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarIntegrantesPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).atualizarIntegrante(integrante.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza o integrante de Id: "+ integrante.getId() + "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                    .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .inserirIntegrante(null))
                    .withRel("Gostaria de inserir um integrante? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                    .withRel("Gostaria de acessar o endpoint de integrantes caching?  Clique aqui!"));
            return integrante;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/por_nome")
    public List<Integrante> retornarIntegrantesPorNome(@RequestParam String nome){
        List<Integrante> todos = integranteCachingService.findAll();
        List<Integrante> retorno = new ArrayList<Integrante>();
        todos.forEach(integrante -> {
            if (integrante.getNome().equalsIgnoreCase(nome)){
                integrante.add(linkTo(methodOn(IntegranteController.class)
                        .retornarTodosIntegrantes())
                        .withRel("Gostaria de acessar o endpoint que retorna todas os integrantes? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class)
                        .retornarIntegrantesPorSubstring(null))
                        .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class).atualizarIntegrante(integrante.getId(), null))
                        .withRel("Gostaria de acessar o endpoint que atualiza o integrante de Id: "+ integrante.getId() + "? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class).paginar(null, null))
                        .withRel("Gostaria de acessar o endpoint de paginar? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                        .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integrante.getId()))
                        .withRel("Gostaria de acessar o endpoint que retorna integrantes por id? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                        .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class)
                        .inserirIntegrante(null))
                        .withRel("Gostaria de inserir um integrante? Clique aqui!"));

                integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                        .withRel("Gostaria de acessar o endpoint de integrantes caching?  Clique aqui!"));
                retorno.add(integrante);
            }
        });
        return retorno;
    }

    @GetMapping(value = "/por_nome_otimizado")
    public List<Integrante> retornarIntegrantesPorNomeOtimizado(@RequestParam String nome){
        List<Integrante> integrantesOtimizados = integranteCachingService.findIntegranteByName(nome);
        integrantesOtimizados.forEach(integrante -> {
            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarTodosIntegrantes())
                    .withRel("Gostaria de acessar o endpoint que retorna todas os integrantes? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarIntegrantesPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).atualizarIntegrante(integrante.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza o integrante de Id: "+ integrante.getId() + "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integrante.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna integrante por ID? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).paginar(null,null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por paginar? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                    .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .inserirIntegrante(null))
                    .withRel("Gostaria de inserir um integrante? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                    .withRel("Gostaria de acessar o endpoint de integrantes caching?  Clique aqui!"));
        });
        return integrantesOtimizados;
    }

    @GetMapping(value = "/paginados")
    public ResponseEntity<Page<IntegranteDTO>> paginar(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "2") Integer size){
        PageRequest req = PageRequest.of(page, size);
        Page<IntegranteDTO> paginadas = integrantePaginacaoService.paginar(req);
        paginadas.forEach(integrante -> {
            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarTodosIntegrantes())
                    .withRel("Gostaria de acessar o endpoint que retorna todas os integrantes? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarIntegrantesPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).atualizarIntegrante(integrante.getId(), null))
                    .withRel("Gostaria de acessar o endpoint que atualiza o integrante de Id: "+ integrante.getId() + "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integrante.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna integrante por ID? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                    .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .inserirIntegrante(null))
                    .withRel("Gostaria de inserir um integrante? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                    .withRel("Gostaria de acessar o endpoint de integrantes caching?  Clique aqui!"));
        });
        return ResponseEntity.ok(paginadas);
    }

    @PutMapping(value = "/atualizar/{id}")
    public Integrante atualizarIntegrante(@PathVariable Long id, @RequestBody @Valid Integrante integrante){
        Optional<Integrante> op = integranteRepository.findById(id);
        if (op.isPresent()){
            Integrante integranteBanco = op.get();
            integranteBanco.tranferirIntegrante(integrante);
            integranteRepository.save(integranteBanco);
            integranteCachingService.removerCache();
            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarTodosIntegrantes())
                    .withRel("Gostaria de acessar o endpoint que retorna todas os integrantes? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .retornarIntegrantesPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint que retorna todos os integrantes paginados? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integrante.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna integrante por ID? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                    .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class)
                    .inserirIntegrante(null))
                    .withRel("Gostaria de inserir um integrante? Clique aqui!"));

            integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                    .withRel("Gostaria de acessar o endpoint de integrantes caching?  Clique aqui!"));
            return integranteBanco;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/novo")
    public Integrante inserirIntegrante(@RequestBody @Valid Integrante integrante){
        integranteRepository.save(integrante);
        integranteCachingService.removerCache();
        integrante.add(linkTo(methodOn(IntegranteController.class)
                .retornarTodosIntegrantes())
                .withRel("Gostaria de acessar o endpoint que retorna todas os integrantes? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class)
                .retornarIntegrantesPorSubstring(null))
                .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class).paginar(null, null))
                .withRel("Gostaria de acessar o endpoint que retorna todos os integrantes paginados? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integrante.getId()))
                .withRel("Gostaria de acessar o endpoint que retorna integrante por ID? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class).removerIntegrante(integrante.getId()))
                .withRel("Gostaria de remover o integrante de id: " + integrante.getId()+ "? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class)
                .atualizarIntegrante(integrante.getId(), null))
                .withRel("Gostaria de atualizar um integrante " + integrante.getNome() + "? Clique aqui!"));

        integrante.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                .withRel("Gostaria de acessar o endpoint de integrantes caching?  Clique aqui!"));

        return integrante;
    }

    @DeleteMapping(value = "/remover/{id}")
    public Integrante removerIntegrante(@PathVariable Long id){
        Optional<Integrante> op = integranteRepository.findById(id);
        if(op.isPresent()){

            integranteRepository.delete(op.get());
            integranteCachingService.removerCache();
            Integrante integranteDeletado = op.get();

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class)
                    .retornarTodosIntegrantes())
                    .withRel("Gostaria de acessar o endpoint que retorna todas os integrantes? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class)
                    .retornarIntegrantesPorSubstring(null))
                    .withRel("Gostaria de acessar o endpoint de busca por substring? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class).paginar(null, null))
                    .withRel("Gostaria de acessar o endpoint que retorna todos os integrantes paginados? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantePorID(integranteDeletado.getId()))
                    .withRel("Gostaria de acessar o endpoint que retorna integrante por ID? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNomeOtimizado(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome (otimizado)? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class).retornarIntegrantesPorNome(null))
                    .withRel("Gostaria de acessar o endpoint que retorna integrantes por nome? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class).inserirIntegrante(null))
                    .withRel("Gostaria de adicionar um novo integrante? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class)
                    .atualizarIntegrante(integranteDeletado.getId(), null))
                    .withRel("Gostaria de atualizar um integrante " + integranteDeletado.getNome() + "? Clique aqui!"));

            integranteDeletado.add(linkTo(methodOn(IntegranteController.class).retornarTodosIntegrantesCaching())
                    .withRel("Gostaria de acessar o endpoint de integrantes caching?  Clique aqui!"));

            return integranteDeletado;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
