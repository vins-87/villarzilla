package it.villarzilla.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import java.util.Date;
import java.util.List;

import it.villarzilla.facade.PazienteFacade;
import it.villarzilla.model.Paziente;

@ManagedBean(name="pazienteController")
public class PazienteController {

	private String nome;
	private String cognome;
	private Date dataDiNascita;
	
	private Paziente paziente;
	
	@EJB
	private PazienteFacade pazienteFacade;
	
	public PazienteController(){
		
	}
	
	public String createPaziente() {
		this.paziente = pazienteFacade.createPaziente(nome, cognome, dataDiNascita);
		return "/paziente.xhtml";
	}
	
	public List<Paziente> getList() {
		return pazienteFacade.getAllPaziente();
	}
	
	//INIZIO GETTER AND SETTER
	public PazienteFacade getPazienteFacade() {
		return pazienteFacade;
	}

	public void setPazienteFacade(PazienteFacade pazienteFacade) {
		this.pazienteFacade = pazienteFacade;
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

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	
	
	
}
