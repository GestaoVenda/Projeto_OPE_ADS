package br.com.opeads.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contact implements Serializable {


	private static final long serialVersionUID = 1931261945393688431L;

	@Column(name = "id_contact")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_client")
	private Client client;
	
	@OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
	private List<CellPhone> cellPhones;
	
	@OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
	private List<Phone> phones;
	
	@OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
	private List<Email> emails;
	
	@Column(name = "name_contact")
	private String contactName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<CellPhone> getCellPhones() {
		return cellPhones;
	}

	public void setCellPhones(List<CellPhone> cellPhones) {
		this.cellPhones = cellPhones;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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
		Contact other = (Contact) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	

}
