package br.com.opeads.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_address")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String street;
	
	private Integer number;
	
	private String neighborhood;
	
	private String city;
	
	private String district;
	
	@Column(name = "zipcode")
	private String zipCode;
	
	private String complement;
	
	private boolean main;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_type_address")
	private TypeAddress idTypeAddress;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_person")
	private Person idPerson;

}
