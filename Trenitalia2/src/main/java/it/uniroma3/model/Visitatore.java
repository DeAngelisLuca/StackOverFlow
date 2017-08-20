package it.uniroma3.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Visitatore {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=3, message="Inserisci un nome")
	private String nome;
	
	@Size(min=3, message="Inserisci un cognome")
	private String cognome;
	
	@Size(min=1, message="Inserisci un indirizzo email")
	@Email(message="Formato email non corretto")
	private String email;
	
	@Size(min=4, message="Inserisci una password con almeno 4 caratteri")
	private String password;
	
	private String messaggioNote;

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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public String getMessaggioNote() {
		return messaggioNote;
	}

	public void setMessaggioNote(String messaggioNote) {
		this.messaggioNote = messaggioNote;
	}
	
	

}
