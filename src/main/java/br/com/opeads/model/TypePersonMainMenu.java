package br.com.opeads.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "type_person_main_menu")
public class TypePersonMainMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "fk_id_type_person")
	private TypePerson idTypePerson;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "fk_id_main_menu")
	private MainMenu idMainMenu;

	
}
