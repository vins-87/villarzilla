package it.villarzilla.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.EsameFacade;
import it.villarzilla.model.Esame;

@ManagedBean(name="esameController")
public class EsameController {

	@EJB
	private EsameFacade esameFacade;
	
	public EsameController(){
		
	}
	
	public List<Esame> getList(){
		return esameFacade.getAllEsame();
	}
	
	
}
