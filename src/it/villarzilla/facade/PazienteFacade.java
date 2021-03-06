package it.villarzilla.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	
	public Paziente createPaziente(String username, String password, String nome, String cognome, Date dataDiNascita){
		Paziente p= new Paziente();
		p.setUsername(username);
		p.setPassword(password);
		p.setNome(nome);
		p.setCognome(cognome);
		p.setDataDiNascita(dataDiNascita);
		this.em.persist(p);
		return p;
	}
	
	public List<Paziente> getAllPaziente(){
		return this.em.createNamedQuery("Paziente.findAll", Paziente.class).getResultList();
	}
	
	public Paziente getPaziente(Long id) {
		try {
			return this.em.createNamedQuery("Paziente.findById", Paziente.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Paziente getPaziente(String username) {
		try {
			return this.em.createNamedQuery("Paziente.findByUsername", Paziente.class).setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
