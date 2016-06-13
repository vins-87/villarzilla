package it.villarzilla.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.AmministratoreFacade;
import it.villarzilla.manager.AmministrazioneManager;
import it.villarzilla.model.Amministratore;

@ManagedBean(name="amministrazioneController")
public class AmministrazioneController {
	
	private String nome;
	private String password;
	
	private AmministrazioneManager sessione;
	
	@EJB
	public AmministratoreFacade amministratoreFacade;
	
	public AmministrazioneController(){
		
	}
	
	public String accedi(Amministratore a){
		if(a.getPassword().equals(this.password)){
			this.sessione.login(a);
			return "/portaleAmministratore/portaleAdmin.xhtml?faces-redirect=true";
		}
		return "/loginAdmin.xhtml";
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
