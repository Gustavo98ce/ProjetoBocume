package br.unifor.bocume.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.bocume.api.models.Restaurante;
import br.unifor.bocume.api.repositories.RestauranteRepository;

@CrossOrigin
@RestController
@RequestMapping("/restaurante")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepo;
	@GetMapping("/{nome}")
	public ResponseEntity<Restaurante> buscaRestaurantePorNome(@PathVariable String nome){
		Optional<Restaurante> restaurante = restauranteRepo.findByNome(nome);
		return ResponseEntity.ok(restaurante.get());			
		
	}
	

	@GetMapping("/{endereco}")
	public ResponseEntity<Restaurante> buscaRestaurantePorEndereco(@PathVariable String endereco){
		Optional<Restaurante> restaurante = restauranteRepo.findByEndereco(endereco);
		return ResponseEntity.ok(restaurante.get());			
		
	}
	
	
	
	
}
