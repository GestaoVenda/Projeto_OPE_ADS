package br.com.opeads.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6991959437151060736L;

	@Column(name = "id_type")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_type")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "user_type", joinColumns = @JoinColumn(name = "fk_id_type"), inverseJoinColumns = @JoinColumn(name = "fk_id_user"))
	private List<User> users;
	
	@ManyToMany
	@JoinTable(name = "type_menu", joinColumns = @JoinColumn(name = "fk_id_type"), inverseJoinColumns = @JoinColumn(name = "fk_id_menu"))
	private List<Menu> menus;
	
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		Type other = (Type) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
