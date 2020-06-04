package br.unifor.bocume.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.bocume.api.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	
}
