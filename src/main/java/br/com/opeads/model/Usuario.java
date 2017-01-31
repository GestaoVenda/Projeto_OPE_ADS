package br.com.opeads.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = -6232276199044450530L;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "id_usuario")
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false)
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false)
	private String banco;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false)
	private String conta;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false)
	private String agencia;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false, unique = true)
	private String login;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false)
	private String senha;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "dt_criacao", columnDefinition = "datetime default CURRENT_TIMESTAMP")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date criacao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(nullable = false, unique = true)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	@OneToOne(mappedBy = "usuario")
	private EnderecoUsuario endereco;

	public EnderecoUsuario getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoUsuario endereco) {
		this.endereco = endereco;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
