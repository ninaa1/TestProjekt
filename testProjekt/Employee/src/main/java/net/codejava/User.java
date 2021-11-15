package net.codejava;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="users", uniqueConstraints= @UniqueConstraint(columnNames="email"))
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="email")
	private String email;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(
		            name = "id_user", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "id_role", referencedColumnName = "id"))
	
	
	private Collection<Role> roles;

	public User() {
		
	}
	
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmil() {
		return email;
	}
	public void setEmil(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String email, String name, String password, Collection<Role> roles) {
		super();
		
		this.email = email;
		this.name = name;
		this.password = password;
		this.roles = roles;
	}
	
	
	
	
	
}
