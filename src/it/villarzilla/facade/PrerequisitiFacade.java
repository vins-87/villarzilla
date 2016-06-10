package it.villarzilla.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Prerequisiti;

@Stateless
public class PrerequisitiFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public PrerequisitiFacade(EntityManager em) {
		this.em = em;
	}
	
	public PrerequisitiFacade(){
		
	}
	
	public Prerequisiti createPrerequisiti(String nome, String descrizione){
		Prerequisiti p = new Prerequisiti();
		p.setNome(nome);
		p.setDescrizione(descrizione);
		this.em.persist(p);
		return p;
	}
	
	public List<Prerequisiti> getAllPrerequisiti(){
		return this.em.createNamedQuery("Prerequisiti.findAll", Prerequisiti.class).getResultList();
	}
}
