package br.unifor.bocume.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name= "usuario")
public class Usuario {

	
	
	@Id 	
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private Long id;
	@NotEmpty
	@Size (max = 10)
	private String nome;
	@NotEmpty
	@Size (max = 30)
	private String sobrenome;
	@NotEmpty
	@Size (max = 80)
	private String endereco;
	@NotEmpty
	@Size (max = 20)
	private String telefone;
	@NotEmpty
	@Size (max = 30)
	private String email;
	@NotEmpty
	@Size (max = 20)
	private String senha;
	
	private Set<Role> role;
	


	@OneToMany(mappedBy = "usuario",cascade= CascadeType.ALL,orphanRemoval = true )
	private List<Pedido> pedidos = new ArrayList<>();

	
	//construtors
	
	
	public Usuario(Long id, @NotEmpty @Size(max = 10) String nome, @NotEmpty @Size(max = 30) String sobrenome,
			@NotEmpty @Size(max = 80) String endereco, @NotEmpty @Size(max = 20) String telefone,
			@NotEmpty @Size(max = 30) String email, @NotEmpty @Size(max = 20) String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}


	
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


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	
	public List<Pedido> getPedidos() {
		return pedidos;
	}



	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


	public Set<javax.management.relation.Role> getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	// hash and equals
	
	
	
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
