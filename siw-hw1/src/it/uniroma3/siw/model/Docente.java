package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	private String luogoNascita;
	
	private LocalDate dataNascita;
	
	@Column(nullable = false)
	private String partitaIva;
	
	/*
	 * Fetch: Quando carico un oggetto Docente, sono interessato sicuramente a guardare i corsi
	 * in cui insegna, quindi è giustificato modificare la politica di fetch di defualt (LAZY) in
	 * EAGER.
	 * 
	 * Cascade: Non c'è la necessità di propagare le operazioni sul docente ai suoi insegnamenti.
	 */
	@OneToMany(mappedBy = "docente", fetch = FetchType.EAGER)
	private List<Corso> insegnamenti;

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

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Corso> getInsegnamenti() {
		return insegnamenti;
	}

	public void setInsegnamenti(List<Corso> insegnamenti) {
		this.insegnamenti = insegnamenti;
	}
}
