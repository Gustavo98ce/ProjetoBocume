package br.unifor.bocume.api.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "restaurante")
public class Restaurante {

	@Id 	
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Long id;
	@NotEmpty
	@Size (max = 80)
	private String nome;
	@NotEmpty
	@Size (max = 200)
	private String endereco;
	@Size (max = 500)
	private String comentario;
	
	private int avaliacao;

	
	@OneToMany(mappedBy= "restaurante",cascade= CascadeType.ALL,orphanRemoval = true)
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	@OneToOne (mappedBy = "restaurante"  )
	private Menu menu;	
	
	//construtors
	
	public Restaurante(Long id, @NotEmpty @Size(max = 80) String nome, @NotEmpty @Size(max = 200) String endereco,
			@Size(max = 500) String comentario, int avaliacao, Menu menu) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.comentario = comentario;
		this.avaliacao = avaliacao;
		this.menu = menu;
	}
	
	
	// getters and settres
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereço() {
		return endereco;
	}
	public void setEndereço(String endereço) {
		this.endereco = endereço;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}


	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	//hashs and equals

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
		Restaurante other = (Restaurante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
