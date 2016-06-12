package it.villarzilla.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Esame;
import it.villarzilla.model.Indicatore;
import it.villarzilla.model.Risultato;

@Stateless
public class RisultatoFacade {
	
	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public RisultatoFacade(EntityManager em) {
		this.em = em;
	}
	
	public RisultatoFacade(){
		
	}
	
	public Risultato createRisultato(Esame esame, Indicatore indicatore, String valore){
		Risultato r = new Risultato();
		r.setEsame(esame);
		r.setIndicatore(indicatore);
		r.setValore(valore);
		this.em.persist(r);
		return r;
	}
	
	public List<Risultato> getAllRisultato(){
		return this.em.createNamedQuery("Risultato.findAll", Risultato.class).getResultList();
	}
	
}