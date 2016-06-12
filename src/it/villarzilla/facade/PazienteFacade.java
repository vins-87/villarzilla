package it.villarzilla.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Paziente;

@Stateless
@EJB(name="ejb/PazienteFacade", beanInterface=PazienteFacade.class, beanName="PazienteFacade")
public class PazienteFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public PazienteFacade(EntityManager em) {
		this.em = em;
	}
	
	public PazienteFacade(){
		
	}
	
	public Paziente createPaziente(String nome, String cognome, Date dataDiNascita){
		Paziente p= new Paziente();
		p.setNome(nome);
		p.setCognome(cognome);
		p.setDataDiNascita(dataDiNascita);
		this.em.persist(p);
		return p;
	}
	
	public List<Paziente> getAllPaziente(){
		return this.em.createNamedQuery("Paziente.findAll", Paziente.class).getResultList();
	}
	
}
