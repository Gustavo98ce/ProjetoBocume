package br.unifor.bocume.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.bocume.api.models.Item;
import br.unifor.bocume.api.repositories.ItemRepository;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepo;
	@GetMapping("/{id}")
	public ResponseEntity buscarId (@PathVariable Long id) {
		Optional<Item> item = itemRepo.findById(id);
		return ResponseEntity.ok(item.get());
		
	}
	

}
