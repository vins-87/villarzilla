package it.villarzilla.model;

import java.util.List;

public class TipologiaEsame {
	
	private Long id;
	private String nome;
	private String codice;
	private String descrizione;
	private Double costo;
	private List<Prerequisiti> prerequisiti;
	private List<Esame> esami;
	private List<Indicatore> indicatori;
	
	public TipologiaEsame(){
		
	}
	
	public TipologiaEsame(Long id, String nome, String codice, String descrizione, Double costo,
			List<Prerequisiti> prerequisiti, List<Esame> esami, List<Indicatore> indicatori) {
		super();
		this.id = id;
		this.nome = nome;
		this.codice = codice;
		this.descrizione = descrizione;
		this.costo = costo;
		this.prerequisiti = prerequisiti;
		this.esami = esami;
		this.indicatori = indicatori;
	}

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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public List<Prerequisiti> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisiti> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public List<Esame> getEsami() {
		return esami;
	}

	public void setEsami(List<Esame> esami) {
		this.esami = esami;
	}

	public List<Indicatore> getIndicatori() {
		return indicatori;
	}

	public void setIndicatori(List<Indicatore> indicatori) {
		this.indicatori = indicatori;
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
		TipologiaEsame other = (TipologiaEsame) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
