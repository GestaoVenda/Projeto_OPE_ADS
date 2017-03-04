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

	public TypePerson getIdTypePerson() {
		return idTypePerson;
	}

	public void setIdTypePerson(TypePerson idTypePerson) {
		this.idTypePerson = idTypePerson;
	}

	public MainMenu getIdMainMenu() {
		return idMainMenu;
	}

	public void setIdMainMenu(MainMenu idMainMenu) {
		this.idMainMenu = idMainMenu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMainMenu == null) ? 0 : idMainMenu.hashCode());
		result = prime * result + ((idTypePerson == null) ? 0 : idTypePerson.hashCode());
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
		TypePersonMainMenu other = (TypePersonMainMenu) obj;
		if (idMainMenu == null) {
			if (other.idMainMenu != null)
				return false;
		} else if (!idMainMenu.equals(other.idMainMenu))
			return false;
		if (idTypePerson == null) {
			if (other.idTypePerson != null)
				return false;
		} else if (!idTypePerson.equals(other.idTypePerson))
			return false;
		return true;
	}

	
}
