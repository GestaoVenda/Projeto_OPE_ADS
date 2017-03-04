package br.com.opeads.model;

import java.io.Serializable;

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
	@JoinColumn(name = "fk_id_person_salesman")
	private Person idSalesman;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_id_person_client")
	private Person idClient;
	
}
