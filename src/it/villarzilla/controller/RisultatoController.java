package it.villarzilla.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.RisultatoFacade;
import it.villarzilla.model.Esame;
import it.villarzilla.model.Indicatore;
import it.villarzilla.model.Risultato;

@ManagedBean(name="risultatoController")
public class RisultatoController {

	private String valore;
	private Esame esame;
	private Indicatore indicatore;
	
	private Risultato risultato;
	
	@EJB
	private RisultatoFacade risultatoFacade;
	
	public RisultatoController(){
		
	}
	
	public String createRisultato(){
		this.risultato = risultatoFacade.createRisultato(esame, indicatore, valore);
		return "/risultato.xhtml";
	}
	
	public List<Risultato> getList(){
		return risultatoFacade.getAllRisultato();
	}

	//INIZIO GETTER AND SETTER
	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public Indicatore getIndicatore() {
		return indicatore;
	}

	public void setIndicatore(Indicatore indicatore) {
		this.indicatore = indicatore;
	}

	public Risultato getRisultato() {
		return risultato;
	}

	public void setRisultato(Risultato risultato) {
		this.risultato = risultato;
	}

	public RisultatoFacade getRisultatoFacade() {
		return risultatoFacade;
	}

	public void setRisultatoFacade(RisultatoFacade risultatoFacade) {
		this.risultatoFacade = risultatoFacade;
	}
	
	
}
