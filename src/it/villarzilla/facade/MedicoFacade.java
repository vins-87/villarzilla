package it.villarzilla.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Medico;

@Stateless
public class MedicoFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;
	
	public MedicoFacade(EntityManager em) {
		this.em = em;
	}
	
	public MedicoFacade(){
		
	}
	
	public Medico createMedico(String nome, String cognome, String specializzazione){
		Medico m=new Medico();
		m.setNome(nome);
		m.setCognome(cognome);
		m.setSpecializzazione(specializzazione);
		this.em.persist(m);
		return m;
	}
	
	public List<Medico> getAllMedico(){
		return this.em.createNamedQuery("Medico.findAll", Medico.class).getResultList();
	}
}
