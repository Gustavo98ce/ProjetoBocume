package br.unifor.bocume.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.bocume.api.models.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
	
	Optional<Restaurante> findByNome(String nome);
	Optional<Restaurante> findByEndereco(String endereco);
			
}
