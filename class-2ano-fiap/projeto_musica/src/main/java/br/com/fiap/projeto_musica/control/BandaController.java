package br.com.fiap.projeto_musica.control;

import br.com.fiap.projeto_musica.dto.BandaDTO;
import br.com.fiap.projeto_musica.model.Banda;
import br.com.fiap.projeto_musica.projection.BandaProjection;
import br.com.fiap.projeto_musica.repository.BandaRepository;
import br.com.fiap.projeto_musica.service.BandaCachingService;
import br.com.fiap.projeto_musica.service.BandaPaginacaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/bandas")
public class BandaController {

    @Autowired
    private BandaRepository bandaRepository;

    @Autowired
    private BandaCachingService bandaCachingService;

    @Autowired
    private BandaPaginacaoService bandaPaginacaoService;

    @Operation(description = "Endpoint de retorno de Bandas por nome", summary = "Retorno de lista de Bandas", tags = "Retorno de informações")
    @GetMapping(value = "/por_nome")
    public List<Banda> retornarBandasPorNome(@RequestParam String nome){
        return bandaCachingService.findAll();
    }

    @Operation(description = "Endpoint de retorno de Bandas por nome de forma otimizada", summary = "Retorno de lista de Bandas", tags = "Retorno de informações")
    @GetMapping(value = "/por_nome_otimizado")
    public List<Banda> retornarBandasPorNomeOtimizado(@RequestParam String nome){
        return bandaCachingService.findBandaByName(nome);
    }

    @Operation(description = "Endpoint de retorno de Bandas por substring, apenas a parte mais interessante para o usuário", summary = "Retorno de lista de BandaProjection", tags = "Retorno de informações")
    @GetMapping(value = "/substring")
    public List<BandaProjection>retornarBandasPorSubstring(@RequestParam String substring){
        return bandaCachingService.findBandaBySubstring(substring);
    }

    @Operation(description = "Endpoint de retorno de todas as bandas", summary = "Retorno de lista de Bandas", tags = "Retorno de informações")
    @GetMapping(value = "/todas")
    public List<Banda> retornarTodasBandas(){
        return bandaRepository.findAll();
    }

    @Operation(description = "Endpoint de retorno de Bandas por nome por caching", summary = "Retorno de lista de Bandas", tags = "Retorno de informações")
    @GetMapping(value = "/todas_caching")
    public List<Banda>retornarTodasBandasCaching(){
        return bandaCachingService.findAll();
    }


    @Operation(description = "Endpoint de retorno de Banda pelo ID", summary = "Retorno de Banda", tags = "Retorno de informações")
    @GetMapping(value = "/{id}")
    public Banda retornarBandaPorID(@PathVariable Long id){
        Optional<Banda> op = bandaRepository.findById(id);
        if (op.isPresent()){
            return op.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(description = "Endpoint de retorno de deleção de Banda", summary = "Deleção de Banda", tags = "Deleção")
    @DeleteMapping(value = "/remover/{id}")
    public Banda removerBanda(@PathVariable Long id){
        Optional<Banda> op = bandaRepository.findById(id);
        if (op.isPresent()){
            return op.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(description = "Endpoint que retorna Bandas paginadas", summary = "Pages de Banda", tags = "Retorno de Informções")
    @GetMapping(value = "/paginadas")
    public ResponseEntity<Page<BandaDTO>> paginar(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "2") Integer size){
        PageRequest req = PageRequest.of(page, size);
        Page<BandaDTO> paginadas = bandaPaginacaoService.paginar(req);
        return ResponseEntity.ok(paginadas);
    }

    @Operation(description = "Endpoint de inserir nova Banda", summary = "Inserção de Banda", tags = "Inserção")
    @PostMapping(value = "/nova")
    public Banda inserirBanda(@RequestBody @Valid Banda banda){
        bandaRepository.save(banda);
        bandaCachingService.removerCache();
        return banda;
    }

    @Operation(description = "Endpoint de atualizar uma Banda", summary = "Atualização de Banda", tags = "Atualização")
    @PutMapping(value = "/atualizar/{id}")
    public Banda atualizarBanda(@PathVariable Long id, @RequestBody @Valid Banda banda){
        Optional<Banda> op = bandaRepository.findById(id);
        if (op.isPresent()){
            Banda bandaBanco = op.get();
            bandaBanco.transferirBanda(banda);
            bandaRepository.save(bandaBanco);
            bandaCachingService.removerCache();

            return bandaBanco;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }
}
