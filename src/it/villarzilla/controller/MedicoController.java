package it.villarzilla.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.MedicoFacade;
import it.villarzilla.model.Medico;

@ManagedBean(name="medicoController")
public class MedicoController {

	private String nome;
	private String cognome;
	private String specializzazione;
	
	private Medico medico;
	
	@EJB
	private MedicoFacade medicoFacade;
	
	public MedicoController(){
		
	}
	
	public String createMedico(){
		this.medico = medicoFacade.createMedico(nome, cognome, specializzazione);
		return "/portaleAmministrazione/medico.xhtml";
	}
	
	public List<Medico> getList(){
		return medicoFacade.getAllMedico();
	}

	//INIZIO GETTER AND SETTER
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

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public MedicoFacade getMedicoFacade() {
		return medicoFacade;
	}

	public void setMedicoFacade(MedicoFacade medicoFacade) {
		this.medicoFacade = medicoFacade;
	}
	
	
}
