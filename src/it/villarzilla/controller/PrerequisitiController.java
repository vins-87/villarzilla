package it.villarzilla.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.PrerequisitiFacade;
import it.villarzilla.model.Prerequisiti;

@ManagedBean(name="prerequisitiController")
public class PrerequisitiController {

	private String nome;
	private String descrizione;
	
	private Prerequisiti prerequisiti;
	
	@EJB
	private PrerequisitiFacade prerequisitiFacade;
	
	public PrerequisitiController(){
		
	}
	
	public String createPrerequisiti(){
		this.prerequisiti = prerequisitiFacade.createPrerequisiti(nome, descrizione);
		return "/portaleAmministrazione/prerequisiti.xhtml";
	}
	
	public List<Prerequisiti> getList(){
		return prerequisitiFacade.getAllPrerequisiti();
	}

	//INIZIO GETTER AND SETTER
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Prerequisiti getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(Prerequisiti prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public PrerequisitiFacade getPrerequisitiFacade() {
		return prerequisitiFacade;
	}

	public void setPrerequisitiFacade(PrerequisitiFacade prerequisitiFacade) {
		this.prerequisitiFacade = prerequisitiFacade;
	}
	
	
}
