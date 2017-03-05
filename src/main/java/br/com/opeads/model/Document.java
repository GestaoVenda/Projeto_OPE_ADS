package br.com.opeads.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.opeads.model.helpers.PersonTypeDocumentId;

@Component
@Entity
@Table(name = "document")
@IdClass(PersonTypeDocumentId.class)
public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_id_person")
	private Person idPerson;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_id_type_document")
	private TypeDocument idTypeDocument;
	
	private String value;

	@JsonProperty(access = Access.WRITE_ONLY)
	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}

	public TypeDocument getIdTypeDocument() {
		return idTypeDocument;
	}

	public void setIdTypeDocument(TypeDocument idTypeDocument) {
		this.idTypeDocument = idTypeDocument;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPerson == null) ? 0 : idPerson.hashCode());
		result = prime * result + ((idTypeDocument == null) ? 0 : idTypeDocument.hashCode());
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
		Document other = (Document) obj;
		if (idPerson == null) {
			if (other.idPerson != null)
				return false;
		} else if (!idPerson.equals(other.idPerson))
			return false;
		if (idTypeDocument == null) {
			if (other.idTypeDocument != null)
				return false;
		} else if (!idTypeDocument.equals(other.idTypeDocument))
			return false;
		return true;
	}

	
}
