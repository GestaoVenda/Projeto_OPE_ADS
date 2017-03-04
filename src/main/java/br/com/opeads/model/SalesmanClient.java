package br.com.opeads.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "salesman_client")
public class SalesmanClient implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToMany
	@JoinColumn(name = "id_person")
	private List<Person> idSalesmans;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_id_person_client")
	private Person idClient;

	public List<Person> getIdSalesmans() {
		return idSalesmans;
	}

	public void setIdSalesmans(List<Person> idSalesmans) {
		this.idSalesmans = idSalesmans;
	}

	public Person getIdClient() {
		return idClient;
	}

	public void setIdClient(Person idClient) {
		this.idClient = idClient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
		result = prime * result + ((idSalesmans == null) ? 0 : idSalesmans.hashCode());
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
		SalesmanClient other = (SalesmanClient) obj;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		if (idSalesmans == null) {
			if (other.idSalesmans != null)
				return false;
		} else if (!idSalesmans.equals(other.idSalesmans))
			return false;
		return true;
	}
	
	
}
