package br.unifor.bocume.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.bocume.api.models.Menu;
import br.unifor.bocume.api.repositories.MenuRepository;

@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuRepository menuRepo;
	@GetMapping("/{id}")
	public ResponseEntity buscarId (@PathVariable Long id) {
		Optional<Menu> menu = menuRepo.findById(id);
		return ResponseEntity.ok(menu.get());
		
	}
	
	
}
