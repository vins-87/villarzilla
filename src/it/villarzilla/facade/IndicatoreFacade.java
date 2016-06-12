package it.villarzilla.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
	
	public Indicatore createIndicatore(String nome, TipologiaEsame tipologia){
		Indicatore i=new Indicatore();
		i.setNome(nome);
		i.setTipologia(tipologia);
		this.em.persist(i);
		return i;
	}
	
	public List<Indicatore> getAllIndicatore(){
		return this.em.createNamedQuery("Indicatore.findAll", Indicatore.class).getResultList();
	}
}
