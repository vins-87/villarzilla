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
	private TipologiaEsame tipologiaEsame;
	
	private Esame esame;
	
	@EJB
	private EsameFacade esameFacade;
	
	public EsameController(){
		
	}
	
	public String createEsame(Paziente p){
		this.paziente=p;
		return "/portaleAmministrazione/createEsame.xhtml";
	}
	
	public String createEsame(){
		this.esame = esameFacade.createEsame(dataEsame, paziente, medico, tipologiaEsame);
		return "/portaleAmministrazione/esame.xhtml";
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

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
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
