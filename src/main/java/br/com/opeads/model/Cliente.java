package br.com.opeads.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Cliente implements Serializable{


	private static final long serialVersionUID = 604341977370563622L;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "id_cliente")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "dt_criacao", columnDefinition = "datetime default CURRENT_TIMESTAMP")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime criacao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false, columnDefinition = "bit default 0")
	private Boolean inativo;
	
	@JsonInclude(Include.NON_NULL)
	@OneToOne(mappedBy = "cliente")
	private ClientePF clientePF;
	
	@JsonInclude(Include.NON_NULL)
	@OneToOne(mappedBy = "cliente")
	private ClientePF clientePJ;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "cliente")
	private List<Contato> contato;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> endereco;
	
	
	public ClientePF getClientePF() {
		return clientePF;
	}

	public void setClientePF(ClientePF clientePF) {
		this.clientePF = clientePF;
	}

	
	public ClientePF getClientePJ() {
		return clientePJ;
	}

	public void setClientePJ(ClientePF clientePJ) {
		this.clientePJ = clientePJ;
	}
	
	
	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}
	
	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public void setCriacao(LocalDateTime criacao) {
		this.criacao = criacao;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
