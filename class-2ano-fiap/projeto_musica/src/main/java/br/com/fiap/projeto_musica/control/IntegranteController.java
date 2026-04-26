package br.com.fiap.projeto_musica.control;

import br.com.fiap.projeto_musica.dto.IntegranteDTO;
import br.com.fiap.projeto_musica.model.Integrante;
import br.com.fiap.projeto_musica.projection.IntegranteProjection;
import br.com.fiap.projeto_musica.repository.IntegranteRepository;
import br.com.fiap.projeto_musica.service.IntegranteCachingService;
import br.com.fiap.projeto_musica.service.IntegrantePaginacaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


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

    @Operation(description = "Endpoint para retornar todos Inegrantes do repository.", summary = "Retorno de Lista de Integrantes", tags = "Retorno de Informação")
    @GetMapping("/todos")
    public List<Integrante> retornarTodosIntegrantes(){
        return integranteRepository.findAll();

    }

    @Operation(description = "Endpoint que retorna todos Integrantes por caching", summary = "Retorno de Lista de Integrantes", tags = "Retorno de Informação")
    @GetMapping(value = "/todos_caching")
    public List<Integrante>retornarTodosIntegrantesCaching(){

        return integranteCachingService.findAll();

    }


    @Operation(description = "Retorna parte de Integrantes, por substring. O que mais interessa ao usuário.", summary = "Retorno de Lista de IntegranteProjection", tags = "Retorno de Informação")
    @GetMapping(value = "/substring")
    public List<IntegranteProjection> retornarIntegrantesPorSubstring(@RequestParam String substring){
        return integranteCachingService.findIntegranteBySubstring(substring);
    }

    @Operation(description = "Retorna Integrante pelo ID.", summary = "Retorno de Integrante", tags = "Retorno de Informação")
    @GetMapping(value =  "/{id}")
    public Integrante retornarIntegrantePorID(@PathVariable Long id){
        Optional<Integrante> op = integranteCachingService.findById(id);
        if (op.isPresent()){
            return op.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @Operation(description = "Endpoint que retorna Integrantes por nome", summary = "Retorno de Lista de Integrantes", tags = "Retorno de Informação")
    @GetMapping(value = "/por_nome")
    public List<Integrante> retornarIntegrantesPorNome(@RequestParam String nome){
        List<Integrante> todos = integranteCachingService.findAll();
        List<Integrante> retorno = new ArrayList<Integrante>();
        todos.forEach(integrante -> {
            if (integrante.getNome().equalsIgnoreCase(nome)){
                retorno.add(integrante);
            }
        });
        return retorno;
    }

    @Operation(description = "Endpoint que retorna Integrantes por nome de forma otimizada", summary = "Retorno de Lista de Integrantes", tags = "Retorno de Informação")
    @GetMapping(value = "/por_nome_otimizado")
    public List<Integrante> retornarIntegrantesPorNomeOtimizado(@RequestParam String nome){
        return integranteCachingService.findIntegranteByName(nome);
    }

    @Operation(description = "Retorna paginas de Integrante", summary = "Retorno de Pagina de Integrantes DTO", tags = "Retorno de Informação")
    @GetMapping(value = "/paginados")
    public ResponseEntity<Page<IntegranteDTO>> paginar(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "2") Integer size){
        PageRequest req = PageRequest.of(page, size);
        Page<IntegranteDTO> paginadas = integrantePaginacaoService.paginar(req);
        return ResponseEntity.ok(paginadas);
    }

    @Operation(description = "Endpoint para atualizar um Integrante pelo id", summary = "Atualização de Integrante", tags = "Atualização")
    @PutMapping(value = "/atualizar/{id}")
    public Integrante atualizarIntegrante(@PathVariable Long id, @RequestBody @Valid Integrante integrante){
        Optional<Integrante> op = integranteRepository.findById(id);
        if (op.isPresent()){
            Integrante integranteBanco = op.get();
            integranteBanco.tranferirIntegrante(integrante);
            integranteRepository.save(integranteBanco);
            integranteCachingService.removerCache();
            return integranteBanco;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(description = "Endpoint para inserir um Integrante", summary = "Inserir Integrante", tags = "Inserção")
    @PostMapping(value = "/novo")
    public Integrante inserirIntegrante(@RequestBody @Valid Integrante integrante){
        integranteRepository.save(integrante);
        integranteCachingService.removerCache();
        return integrante;
    }

    @Operation(description = "Endpoint de deleção de Integrante",summary = "Deleção de Integrante", tags = "Deleção")
    @DeleteMapping(value = "/remover/{id}")
    public Integrante removerIntegrante(@PathVariable Long id){
        Optional<Integrante> op = integranteRepository.findById(id);
        if(op.isPresent()){
            integranteRepository.delete(op.get());
            integranteCachingService.removerCache();
            return op.get();

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
