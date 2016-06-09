package it.villarzilla.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

import it.villarzilla.facade.PazienteFacade;
import it.villarzilla.model.Paziente;

@ManagedBean(name="pazienteController")
public class PazienteController {

	@EJB
	private PazienteFacade pazienteFacade;
	
	public PazienteController(){
		
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
	
	
}
