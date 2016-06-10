package it.villarzilla.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Esame;
import it.villarzilla.model.Medico;
import it.villarzilla.model.Paziente;

@Stateless
public class EsameFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public EsameFacade(EntityManager em) {
		this.em = em;
	}
	
	public EsameFacade(){
		
	}
	
	public Esame createEsame(Date prenotazione, Date dataEsame, Paziente paziente, Medico medico){
		Esame e=new Esame();
		e.setPrenotazione(prenotazione);
		e.setEsame(dataEsame);
		e.setPaziente(paziente);
		e.setMedico(medico);
		this.em.persist(e);
		return e;
	}
	
	public List<Esame> getAllEsame(){
		return this.em.createNamedQuery("Esame.findAll", Esame.class).getResultList();
	}
	
}
