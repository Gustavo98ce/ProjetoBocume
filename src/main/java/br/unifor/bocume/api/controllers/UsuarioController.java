package br.unifor.bocume.api.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.bocume.api.models.Restaurante;
import br.unifor.bocume.api.models.Usuario;
import br.unifor.bocume.api.repositories.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/registro")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario registrarUsuario(@Valid @RequestBody Usuario usuario) {	
		return usuarioRepo.save(usuario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscaUsuarioPorId(@PathVariable Long id){
		Optional<Usuario> usuario = usuarioRepo.findById(id);
		return ResponseEntity.ok(usuario.get());			
		
	}
	
	
	@GetMapping("/{email}")
	public ResponseEntity<Usuario> buscaUsuarioPorEmail(@PathVariable String email){
		Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
		return ResponseEntity.ok(usuario.get());			
		
	}
	

}
