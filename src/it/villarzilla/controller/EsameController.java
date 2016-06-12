package it.villarzilla.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.EsameFacade;
import it.villarzilla.model.Esame;
import it.villarzilla.model.Medico;
import it.villarzilla.model.Paziente;
import it.villarzilla.model.TipologiaEsame;

@ManagedBean(name="esameController")
public class EsameController {

	private Date prenotazione;
	private Date dataEsame;
	private Paziente paziente;
	private Medico medico;
	private TipologiaEsame tipologia;
	
	private Esame esame;
	
	@EJB
	private EsameFacade esameFacade;
	
	public EsameController(){
		
	}
	
	public String createEsame(){
		this.esame = esameFacade.createEsame(prenotazione, dataEsame, paziente, medico);
		return "/esame.xhtml";
	}
	
	public List<Esame> getList(){
		return esameFacade.getAllEsame();
	}

	public Date getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Date prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Date getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
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

	public EsameFacade getEsameFacade() {
		return esameFacade;
	}

	public void setEsameFacade(EsameFacade esameFacade) {
		this.esameFacade = esameFacade;
	}

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}
	
	
	
	
}
