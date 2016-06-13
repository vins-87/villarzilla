package it.villarzilla.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.villarzilla.model.Amministratore;

@ManagedBean(name = "adminManager")
@SessionScoped
public class AmministrazioneManager {

    private Amministratore current;

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/loginAdmin.xhtml?faces-redirect=true";
    }
    
    public void login(Amministratore a){
    	this.current = a;
    }
    
	public Amministratore getCurrent() {
		return this.current;
	}

	public boolean isLogged() {
		return this.current!=null;
	}


}