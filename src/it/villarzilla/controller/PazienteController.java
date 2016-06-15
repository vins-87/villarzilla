package it.villarzilla.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import java.util.Date;
import java.util.List;

import it.villarzilla.facade.PazienteFacade;
import it.villarzilla.manager.PazienteManager;
import it.villarzilla.model.Paziente;

@ManagedBean(name="pazienteController")
public class PazienteController {

	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	
	private Paziente paziente;
	
	@ManagedProperty(value = "#{pazienteManager}")
	private PazienteManager sessione;
	
	@EJB
	private PazienteFacade pazienteFacade;
	
	public PazienteController(){
		
	}
	
	public String createPaziente() {
		this.paziente = pazienteFacade.createPaziente(username, password, nome, cognome, dataDiNascita);
		return "/portalePaziente/paziente.xhtml";
	}
	
	public String accedi(){
		Paziente paziente = this.pazienteFacade.getPaziente(this.username);
		if(paziente!=null){
			if(paziente.getPassword().equals(this.password)){
				this.sessione.login(paziente);
				return "/portalePaziente/portalePaziente.xhtml";
			} else {
				return "/loginPaziente.xhtml";
			}
		}
		return "/loginPaziente.xhtml";
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
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PazienteManager getSessione() {
		return sessione;
	}

	public void setSessione(PazienteManager sessione) {
		this.sessione = sessione;
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
