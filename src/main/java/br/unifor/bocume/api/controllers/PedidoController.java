package br.unifor.bocume.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.bocume.api.models.Pedido;
import br.unifor.bocume.api.repositories.PedidoRepository;

@CrossOrigin
@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepo;
	@GetMapping("/{id}")
	public ResponseEntity buscarId (@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepo.findById(id);
		return ResponseEntity.ok(pedido.get());
		
	}
	

}
