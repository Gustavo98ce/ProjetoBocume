package br.unifor.bocume.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.bocume.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

	Optional<Usuario> findByEmail(String email);
	
	Usuario findUsuarioByEmail(String email);
		
}
