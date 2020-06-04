package br.unifor.bocume.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.bocume.api.models.Menu;

public interface MenuRepository extends JpaRepository<Menu , Long> {

}
