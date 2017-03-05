package br.com.opeads.model.helpers;

import java.io.Serializable;


public class PersonTypeDocumentId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPerson;
	
	private Long idTypeDocument;

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public Long getIdTypeDocument() {
		return idTypeDocument;
	}

	public void setIdTypeDocument(Long idTypeDocument) {
		this.idTypeDocument = idTypeDocument;
	}
	
	@Override
    public int hashCode() {
        return (int) (idPerson + idTypeDocument);
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PersonTypeDocumentId){
        	PersonTypeDocumentId personTypeDocumentId = (PersonTypeDocumentId) obj;
            return personTypeDocumentId.idTypeDocument == idTypeDocument && personTypeDocumentId.idPerson == idPerson;
        }
 
        return false;
    }

}
