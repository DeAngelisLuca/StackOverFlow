package it.uniroma3.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "app_user")
public class Utente  {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=3, message="Inserisci un nome")
	private String nome;
	
	@Size(min=1, message="Inserisci un indirizzo email")
	@Email(message="Formato email non corretto")
	private String email;
	
	@Size(min=4, message="Inserisci una password con almeno 4 caratteri")
	private String password;
	
	private boolean enabled;
	
	@ManyToMany
	@JoinTable
	private List<Ruolo> ruoli;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
		
}
