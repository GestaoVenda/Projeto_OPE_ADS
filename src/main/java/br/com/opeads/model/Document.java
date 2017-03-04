package br.com.opeads.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.opeads.model.helpers.PersonTypeDocumentId;

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

}
