package it.villarzilla.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.villarzilla.facade.AmministratoreFacade;
import it.villarzilla.manager.AmministrazioneManager;
import it.villarzilla.model.Amministratore;

@ManagedBean(name="amministrazioneController")
public class AmministrazioneController {
	
	private String nome;
	private String password;
	
	private Amministratore amministratore;
	
	@ManagedProperty(value = "#{amministrazioneManager}")
	private AmministrazioneManager sessione;
	
	@EJB
	public AmministratoreFacade amministratoreFacade;
	
	public AmministrazioneController(){
		
	}
	
	public String createAmministratore() {
		this.amministratore = amministratoreFacade.createAmministratore(nome, password);
		return "/amministratore.xhtml";
	}
	
	public String accedi(Amministratore amministratore){
		if(amministratore.getPassword().equals(this.password)){
			this.sessione.login(amministratore);
			return "/portaleAmministratore/portaleAmministratore.xhtml?faces-redirect=true";
		}
		return "/loginAdmin.xhtml";
	}

	//Inizio Getter & Setter
	
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

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public AmministrazioneManager getSessione() {
		return sessione;
	}

	public void setSessione(AmministrazioneManager sessione) {
		this.sessione = sessione;
	}
	
	
}
