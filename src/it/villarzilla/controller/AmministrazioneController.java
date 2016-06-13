package it.villarzilla.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.AmministratoreFacade;

@ManagedBean(name="amministrazioneController")
public class AmministrazioneController {
	
	private String nome;
	private String password;
	
	@EJB
	public AmministratoreFacade amministratoreFacade;
	
	public AmministrazioneController(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AmministratoreFacade getAmministratoreFacade() {
		return amministratoreFacade;
	}

	public void setAmministratoreFacade(AmministratoreFacade amministratoreFacade) {
		this.amministratoreFacade = amministratoreFacade;
	}
	
	
}
