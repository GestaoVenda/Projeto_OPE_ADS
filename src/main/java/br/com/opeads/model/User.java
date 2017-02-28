package br.com.opeads.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "user")
public class User implements Serializable {

	
	private static final long serialVersionUID = -6232276199044450530L;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "id_user")
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "name_user",  nullable = false)
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "bank", nullable = false)
	private String bank;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "account", nullable = false)
	private String account;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "agency", nullable = false)
	private String agency;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "login", nullable = false, unique = true)
	private String login;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "password", nullable = false)
	private String password;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "dt_creation")
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date creation;
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	@OneToOne(mappedBy = "user")
	private UserAddress address;
	

	@ManyToMany
	@JoinTable(name = "user_group",joinColumns = @JoinColumn(name = "fk_id_user"),
	inverseJoinColumns = @JoinColumn(name = "fk_id_group"))
	private List<Group> groups;

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
