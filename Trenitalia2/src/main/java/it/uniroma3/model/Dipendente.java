package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

@Entity
public class Dipendente {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=3,message="Inserisci un nome valido")
	private String nome;
	
	@Size(min=1,message="Inserisci un cognome valido")
	private String cognome;
	
	@NumberFormat
	private Integer cid;
	
	@Size(min=3,message="Inserisci un impianto valido")
	private String impianto;
	
	
	
	@OneToMany(mappedBy="dipendente", cascade = CascadeType.REMOVE)
	private List<Abilitazione> abilitazioni;

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

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public List<Abilitazione> getAbilitazioni() {
		return abilitazioni;
	}

	public void setAbilitazioni(List<Abilitazione> abilitazioni) {
		this.abilitazioni = abilitazioni;
	}
	
	public String getImpianto() {
		return impianto;
	}
	
	public void setImpianto(String impianto) {
		this.impianto = impianto;
	}


}
