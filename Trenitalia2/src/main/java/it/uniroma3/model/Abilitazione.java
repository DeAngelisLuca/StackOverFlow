package it.uniroma3.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jboss.logging.Message;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Abilitazione {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message="Non è un nome valido")
	private String nomeAbilitazione;
	@Size(min=3, message="Non è un link valido")
	private String linkAllegato;
	@Size(max=1, message="Non è uno stato valido")
	private String info;
	
	@NotNull
	@Min(1)
	@Max(31)
	private Integer giornoScadenza;
	
	@NotNull
	@Min(1)
	@Max(12)
	private Integer meseScadenza;
	
	@NotNull
	@Min(2000)
	@Max(2100)
	private Integer annoScadenza;
	
	@NotNull
	@Min(1)
	@Max(31)
	private Integer giornoConseguimento;
	
	@NotNull
	@Min(1)
	@Max(12)
	private Integer meseConseguimento;
	
	@NotNull
	@Min(2000)
	@Max(2100)
	private Integer annoConseguimento;
	
	private LocalDate dataLocale;
	private LocalDate dataScadenzaAbilitazioneTot;
	private LocalDate dataConseguimentoAbilitazioneTot;
	
	

	@ManyToOne
	private Dipendente dipendente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAbilitazione() {
		return nomeAbilitazione;
	}

	public void setNomeAbilitazione(String nomeAbilitazione) {
		this.nomeAbilitazione = nomeAbilitazione;
	}

	public String getLinkAllegato() {
		return linkAllegato;
	}

	public void setLinkAllegato(String linkAllegato) {
		this.linkAllegato = linkAllegato;
	}

	public Dipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	
	public LocalDate getDataLocale() {
		this.dataLocale = LocalDate.now();
		return dataLocale;
	}
	
	public void setDataLocale(LocalDate dataLocale) {
		this.dataLocale = dataLocale;
	}
	
	public Integer getGiornoScadenza() {
		return giornoScadenza;
	}

	public void setGiornoScadenza(Integer giornoScadenza) {
		this.giornoScadenza = giornoScadenza;
	}

	public Integer getMeseScadenza() {
		return meseScadenza;
	}
	
	public Integer getAnnoConseguimento() {
		return annoConseguimento;
	}
	
	public Integer getGiornoConseguimento() {
		return giornoConseguimento;
	}
	
	public Integer getMeseConseguimento() {
		return meseConseguimento;
	}
	
	public void setAnnoConseguimento(Integer annoConseguimento) {
		this.annoConseguimento = annoConseguimento;
	}
	
	public void setGiornoConseguimento(Integer giornoConseguimento) {
		this.giornoConseguimento = giornoConseguimento;
	}
	
	public void setMeseConseguimento(Integer meseConseguimento) {
		this.meseConseguimento = meseConseguimento;
	}

	public void setMeseScadenza(Integer meseScadenza) {
		this.meseScadenza = meseScadenza;
	}

	public Integer getAnnoScadenza() {
		return annoScadenza;
	}

	public void setAnnoScadenza(Integer annoScadenza) {
		this.annoScadenza = annoScadenza;
	}
	
	public LocalDate getDataConseguimentoAbilitazioneTot() {
		return dataConseguimentoAbilitazioneTot;
	}
	
	public void setDataConseguimentoAbilitazioneTot(LocalDate dataConseguimentoAbilitazioneTot) {
		this.dataConseguimentoAbilitazioneTot = dataConseguimentoAbilitazioneTot;
	}
	
	public LocalDate getDataScadenzaAbilitazioneTot() {
		return dataScadenzaAbilitazioneTot;
	}
	
	public void setDataScadenzaAbilitazioneTot(LocalDate dataScadenzaAbilitazioneTot) {
		this.dataScadenzaAbilitazioneTot = dataScadenzaAbilitazioneTot;
	}

	
	


}
