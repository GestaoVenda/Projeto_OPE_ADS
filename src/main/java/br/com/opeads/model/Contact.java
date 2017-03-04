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
@Table(name = "contact")
public class Contact implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_contact")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String phone;
	
	@Column(name = "cellphone")
	private String cellPhone;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "fk_id_person")
	private Person idPerson;
	
}
