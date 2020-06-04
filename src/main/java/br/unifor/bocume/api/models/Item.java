package br.unifor.bocume.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name="item")
public class Item {

	@Id 	
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Long id;
	
	@NotEmpty
	@Size (max = 80)
	private String nome;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name =  "pedido_id")
	private Pedido pedido;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name =  "menu_id")
	private Menu menu;
	
	@NotEmpty	
	private float valor;
	
	@NotEmpty
	@Size(max=80)
	private String imagem;
	
	
	
	
	
	//getters and setters
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
				
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
		
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
		
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
	//hash and equals
	
	
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
