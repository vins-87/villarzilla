package it.villarzilla.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

public class Esame {
	
	private Long id;
	private Date prenotazione;
	private Date esame;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Paziente paziente;
	
	private Medico medico;
	private TipologiaEsame tipologia;
	private List<Risultato> risultati;
	
	public Esame(){
		
	}

	public Esame(Long id, Date prenotazione, Date esame, Paziente paziente, Medico medico, TipologiaEsame tipologia,
			List<Risultato> risultati) {
		super();
		this.id = id;
		this.prenotazione = prenotazione;
		this.esame = esame;
		this.paziente = paziente;
		this.medico = medico;
		this.tipologia = tipologia;
		this.risultati = risultati;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Date prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Date getEsame() {
		return esame;
	}

	public void setEsame(Date esame) {
		this.esame = esame;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public TipologiaEsame getTipologia() {
		return tipologia;
	}

	public void setTipologia(TipologiaEsame tipologia) {
		this.tipologia = tipologia;
	}

	public List<Risultato> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<Risultato> risultati) {
		this.risultati = risultati;
	}

	@Override
	public String toString() {
		return this.id + "";
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
		Esame other = (Esame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
