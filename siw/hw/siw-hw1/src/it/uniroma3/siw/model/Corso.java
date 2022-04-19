package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	private LocalDate dataInizio;
	
	private Long durata;
	
	/*
	 * Fetch: l'opzione di default (LAZY) non necessità di essere modificata, quando carico
	 * un corso non è necessario/conveniente caricare anche tutti i suoi allievi.
	 * 
	 * Cascade: Quando voglio effettuare un'operazione sul Corso, non necessito che
	 * questa venga propagata anche ai suoi allievi.
	 */
	@ManyToMany(mappedBy = "corsi")
	private List<Allievo> allievi;
	
	/*
	 * Fetch: l'opzione di defualt (EAGER) va bene, quando carico un corso voglio, in generale,
	 * guardare anche le informazioni relative al docente 
	 * 
	 * Cascade:Quando voglio effettuare un'operazione sul Corso, non necessito che
	 * questa venga propagata anche al suo docente.
	 */
	@ManyToOne
	private Docente docente;

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

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Long getDurata() {
		return durata;
	}

	public void setDurata(Long durata) {
		this.durata = durata;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}
}
