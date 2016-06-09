package it.villarzilla.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="esami")
public class Esame {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date prenotazione;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataEsame;
	
	@Column
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Paziente paziente;
	
	@Column
	@ManyToOne
	private Medico medico;
	
	@Column
	@ManyToOne
	private TipologiaEsame tipologia;
	
	@OneToMany(mappedBy="esame")
	private List<Risultato> risultati;
	
	public Esame(){
		
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
		return dataEsame;
	}

	public void setEsame(Date esame) {
		this.dataEsame = esame;
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
