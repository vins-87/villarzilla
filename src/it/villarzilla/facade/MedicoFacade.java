package it.villarzilla.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Medico;

@Stateless
@EJB(name="ejb/MedicoFacade", beanInterface=MedicoFacade.class, beanName="MedicoFacade")
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
		try{
			return this.em.createNamedQuery("Medico.findAll", Medico.class).getResultList();
		}catch (NoResultException error){
			return null;
		}
	}
	
	public Medico getMedico(Long id) {
		try {
			return this.em.createNamedQuery("Medico.findById", Medico.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
