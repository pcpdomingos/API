package br.org.generation.meuGame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_usuario")
public class Usuario {
	
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@NotNull(message = "O nome precisa ser inserido.")
	private String nome;
	
	@NotNull(message = "O email precisa ser inserido.")
	@Email(message = "O atributo usuário precisa de um email válido.")
	private String usuario;
	
	@NotBlank(message = "O atributo senha precisa ser inserido.")
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("/usuario")
	private List<PedidoModel> pedido;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<PedidoModel> getPedido() {
		return pedido;
	}

	public void setPedido(List<PedidoModel> pedido) {
		this.pedido = pedido;
	}
	
	
	
	
}
