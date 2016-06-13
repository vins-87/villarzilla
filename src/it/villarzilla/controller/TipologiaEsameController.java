package it.villarzilla.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.TipologiaEsameFacade;
import it.villarzilla.model.TipologiaEsame;

@ManagedBean(name="tipologiaEsameController")
public class TipologiaEsameController {
	
	private String nome;
	private String codice;
	private String descrizione;
	private Double costo;
	
	private TipologiaEsame tipologiaEsame;
	
	@EJB
	private TipologiaEsameFacade tipologiaEsameFacade;
	
	public TipologiaEsameController(){
		
	}
	
	public String createTipologiaEsame(){
		this.tipologiaEsame = tipologiaEsameFacade.createTipologiaEsame(nome, codice, costo, descrizione);
		return "/portaleAmministrazione/tipologia.xhtml";
	}
	
	public String viewTipologiaEsame(TipologiaEsame tipologiaEsame){
		this.tipologiaEsame = tipologiaEsame;
		return "/viewTipologia.xhtml";
	}
	
	public List<TipologiaEsame> getList(){
		return tipologiaEsameFacade.getAllTipologiaEsame();
	}

	//INIZIO GETTER AND SETTER
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

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public TipologiaEsameFacade getTipologiaEsameFacade() {
		return tipologiaEsameFacade;
	}

	public void setTipologiaEsameFacade(TipologiaEsameFacade tipologiaEsameFacade) {
		this.tipologiaEsameFacade = tipologiaEsameFacade;
	}
	
	
}
