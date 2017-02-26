package br.com.opeads.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "client")
public class Client implements Serializable{


	private static final long serialVersionUID = 604341977370563622L;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "id_client")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "dt_creation")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date creation;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "inactive",columnDefinition = "BIT DEFAULT 0")
	private Boolean inactive;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "client", fetch=FetchType.LAZY)
	@Column(name = "contact")
	private List<Contact> contacts;
	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "client", fetch=FetchType.LAZY)
	@Column(name = "address")
	private List<Address> addresses;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "name_client")
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "cpf")
	private String cpf;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "razao")
	private String razao;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "cnpj")
	private String cnpj;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	@JsonInclude(Include.NON_NULL)
	@Column
	private String insc;

	

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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
