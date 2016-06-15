package it.villarzilla.manager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import it.villarzilla.model.Paziente;

@ManagedBean(name = "pazienteManager")
@SessionScoped
public class PazienteManager {
    private Paziente current;

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/loginPaziente.xhtml?faces-redirect=true";
    }
    
    public void login(Paziente paziente){
    	this.current = paziente;
    }
    
	public Paziente getCurrent() {
		return this.current;
	}

	public boolean isLogged() {
		return this.current!=null;
	}
}