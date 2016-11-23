package br.com.opeads.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_pj")
public class ClientePJ implements Serializable{

	
	private static final long serialVersionUID = 8804716767172395779L;

	@Id
	@OneToOne(cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Column(nullable = false)
	private String razao;
	
	@Column(nullable = false)
	private String cnpj;
	
	@Column(nullable = false)
	private String insc;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
		ClientePJ other = (ClientePJ) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}
	
	

}
