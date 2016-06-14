package it.villarzilla.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Esame;
import it.villarzilla.model.Medico;
import it.villarzilla.model.Paziente;
import it.villarzilla.model.TipologiaEsame;

@Stateless
@EJB(name="ejb/EsameFacade", beanInterface=EsameFacade.class, beanName="EsameFacade")
public class EsameFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public EsameFacade(EntityManager em) {
		this.em = em;
	}
	
	public EsameFacade(){
		
	}
	
	public Esame createEsame(Date dataEsame, Paziente paziente, Medico medico, TipologiaEsame tipologiaEsame){
		Esame e=new Esame();
		e.setPrenotazione(new Date());
		e.setDataEsame(dataEsame);
		e.setPaziente(paziente);
		e.setMedico(medico);
		e.setTipologiaEsame(tipologiaEsame);
		this.em.persist(e);
		return e;
	}
	
	public List<Esame> getEsami(Medico medico) {
		medico = this.em.merge(medico);
		return medico.getEsami();
	}
	
	public List<Esame> getAllEsame(){
		return this.em.createNamedQuery("Esame.findAll", Esame.class).getResultList();
	}
	
	public Esame getEsame(Long id) {
		try {
			return this.em.createNamedQuery("Esame.findById", Esame.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}
