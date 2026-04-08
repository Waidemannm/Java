package br.com.fiap.projeto_musica.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.fiap.projeto_musica.model.Musica;
import br.com.fiap.projeto_musica.repository.MusicaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/musicas")
public class MusicaController {

	@Autowired
	private MusicaRepository repoM;

	@GetMapping(value = "/todas")
	public List<Musica> retornarTodasMusicas() {
		return repoM.findAll();
	}

	@GetMapping(value = "/{id}")
	public Musica retornarMusicaPorID(@PathVariable Long id) {

		Optional<Musica> op = repoM.findById(id);

		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(value = "/por_duracao_otimizado")
	public List<Musica> retornarMusicasPorDuracaoOtimizado(@RequestParam Double duracao) {
		return repoM.retornarMuicasPorDuracao(duracao);
	}
	
	@GetMapping(value = "/por_duracao")
	public List<Musica> retornarMusicasPorDuracao(@RequestParam Double duracao) {
		
		List<Musica> todas = repoM.findAll();
		List<Musica> retorno = new ArrayList<Musica>();
		
		for(Musica musica : todas) {
			if(musica.getDuracao() <= duracao) {
				retorno.add(musica);
			}
		}
		
		return retorno;

	}	

	@PostMapping(value = "/nova")
	public Musica inserirMusica(@RequestBody @Valid Musica musica) {
		repoM.save(musica);
		return musica;
	}

	@DeleteMapping(value = "/remover/{id}")
	public Musica removerMusica(@PathVariable Long id) {

		Optional<Musica> op = repoM.findById(id);

		if (op.isPresent()) {
			repoM.delete(op.get());
			return op.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(value = "/atualizar/{id}")
	public Musica atualizarMusica(@PathVariable Long id, @RequestBody @Valid Musica musica) {

		Optional<Musica> op = repoM.findById(id);

		if (op.isPresent()) {
			Musica musica_banco = op.get();
			musica_banco.transferirMusica(musica);
			repoM.save(musica_banco);
			return musica_banco;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
