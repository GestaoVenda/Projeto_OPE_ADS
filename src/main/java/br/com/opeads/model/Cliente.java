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
	@Column(name = "dt_criacao")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime criacao;
	
	@JsonInclude(Include.NON_NULL)
	@Column()
	private Boolean inativo;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "cliente")
	private List<Contato> contato;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> endereco;
	
	@JsonInclude(Include.NON_NULL)
	@Column
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@Column
	private String cpf;
	
	@JsonInclude(Include.NON_NULL)
	@Column
	private String razao;
	
	@JsonInclude(Include.NON_NULL)
	@Column
	private String cnpj;
	
	@JsonInclude(Include.NON_NULL)
	@Column
	private String insc;


	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInsc() {
		return insc;
	}

	public void setInsc(String insc) {
		this.insc = insc;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
