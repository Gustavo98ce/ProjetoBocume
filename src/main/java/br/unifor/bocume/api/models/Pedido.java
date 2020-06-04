package br.unifor.bocume.api.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name="pedido")
public class Pedido {
	
	@Id 	
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Long id;	
	
	@NotEmpty
	private float valorTotal;	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name ="usuario_id")
	private Usuario usuario;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn (name =  "restaurante_id")	
	private Restaurante restaurante;	
	
	@NotEmpty
	private String localEntrega;	
		
	@OneToMany(mappedBy = "pedido",cascade= CascadeType.ALL,orphanRemoval = true )
	private List<Item> itensPedido;

	
	//construtors
	public Pedido(Long id, @NotEmpty float valorTotal, @NotEmpty Usuario usuario, @NotEmpty Restaurante restaurante,
			@NotEmpty String localEntrega, @NotEmpty List<Item> itensPedido) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.usuario = usuario;
		this.restaurante = restaurante;
		this.localEntrega = localEntrega;
		this.itensPedido = itensPedido;
	
	}


	
	
	// getters and setters

	public Long getId() {
		return id;
	}



	public float getValorTotal() {
		return valorTotal;
	}



	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Restaurante getRestaurante() {
		return restaurante;
	}



	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}



	public String getLocalEntrega() {
		return localEntrega;
	}



	public void setLocalEntrega(String localEntrega) {
		this.localEntrega = localEntrega;
	}



	public List<Item> getItensPedido() {
		return itensPedido;
	}



	public void setItensPedido(List<Item> itensPedido) {
		this.itensPedido = itensPedido;
	}


	

	
	
	
	

}
