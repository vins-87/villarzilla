package it.villarzilla.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.TipologiaEsame;

@Stateless
public class TipologiaEsameFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public TipologiaEsameFacade(EntityManager em) {
		this.em = em;
	}
	
	public TipologiaEsameFacade(){
		
	}
	
	public TipologiaEsame createTipologiaEsame(String nome, String codice, Double costo, String descrizione){
		TipologiaEsame t = new TipologiaEsame();
		t.setCodice(codice);
		t.setCosto(costo);
		t.setDescrizione(descrizione);
		t.setNome(nome);
		this.em.persist(t);
		return t;
	}
	
	public List<TipologiaEsame> getAllTipologiaEsame(){
		return this.em.createNamedQuery("TipologiaEsame.findAll", TipologiaEsame.class).getResultList();
	}
	
}
