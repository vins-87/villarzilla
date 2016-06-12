package it.villarzilla.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Indicatore;
import it.villarzilla.model.TipologiaEsame;

@Stateless
@EJB(name="ejb/IndicatoreFacade", beanInterface=IndicatoreFacade.class, beanName="IndicatoreFacade")
public class IndicatoreFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public IndicatoreFacade(EntityManager em) {
		this.em = em;
	}
	
	public IndicatoreFacade(){
		
	}
	
	public Indicatore createIndicatore(String nome, TipologiaEsame tipologiaEsame){
		Indicatore i=new Indicatore();
		i.setNome(nome);
		i.setTipologiaEsame(tipologiaEsame);
		this.em.persist(i);
		return i;
	}
	
	public List<Indicatore> getAllIndicatore(){
		return this.em.createNamedQuery("Indicatore.findAll", Indicatore.class).getResultList();
	}
	
	public Indicatore getIndicatore(Long id) {
		try {
			return this.em.createNamedQuery("Indicatore.findById", Indicatore.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
