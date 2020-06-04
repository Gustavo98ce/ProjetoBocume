package br.unifor.bocume.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table (name= "menu")
	public class Menu {
		
	@Id 	
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name= "restaurante_id",referencedColumnName ="id")
	private Restaurante restaurante;
	
	
	
	@OneToMany(mappedBy = "menu",cascade= CascadeType.ALL,orphanRemoval = true )
	private List<Item> itens = new ArrayList<>();
	
	
	
	
	
	//get ands setters
	public Long getId() {
		return id;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
		
		
		
	//hashs and equals
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
