package br.com.fiap.projeto_usuarios.control;

import java.util.List;
import java.util.Optional;

import br.com.fiap.projeto_usuarios.model.ChaveComposta;
import br.com.fiap.projeto_usuarios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.projeto_usuarios.repository.UsuarioRepository;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(value = "/todos")
	public List<Usuario> findALl(){
		return usuarioRepository.findAll();
	}

	@PostMapping(value = "/inserir")
	public Usuario save(@RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}

	@GetMapping(value = "chave_composta/{id}/{rm}")
	public Usuario findById(@PathVariable Integer id, @PathVariable String rm){
		ChaveComposta chaveComposta = new ChaveComposta(id, rm);
		Optional<Usuario> op = usuarioRepository.findById(chaveComposta);
		if (op.isPresent()){
			return op.get();
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
