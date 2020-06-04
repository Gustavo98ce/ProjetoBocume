package br.unifor.bocume.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifor.bocume.api.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
