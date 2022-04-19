package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {
	
	@Id
	private Long matricola;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	private String luogoNascita;
	
	private LocalDate dataNascita;
	
	@Column(nullable = false)
	private String email;
	
	/*
	 * Fetch: Opzione di defualt (EAGER) va bene, quando guardo carico un allievo posso essere interessato
	 * anche alla sua società.
	 * 
	 * Cascade: Non c'è la necessità di propagare le operazioni su un allievo alla sua società.
	 */
	@ManyToOne
	private Societa societa;

	/*
	 * Fetch: Opzione di defualt (LAZY) va bene, quando guardo carico un allievo non necessito di caricare
	 * tutti i corsi che segue.
	 * 
	 * Cascade: Non c'è la necessità di propagare le operazioni su un allievo ai corsi che segue.
	 */
	@ManyToMany
	private List<Corso> corsi;

	public Long getMatricola() {
		return matricola;
	}

	public void setMatricola(Long matricola) {
		this.matricola = matricola;
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

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
}
