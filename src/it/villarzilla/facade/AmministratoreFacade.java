package it.villarzilla.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.villarzilla.model.Amministratore;

@Stateless
@EJB(name="ejb/AmministratoreFacade", beanInterface=AmministratoreFacade.class, beanName="AmministratoreFacade")
public class AmministratoreFacade {

	@PersistenceContext(unitName="villarzilla")
	private EntityManager em;

	public AmministratoreFacade(EntityManager em) {
		this.em = em;
	}
	
	public AmministratoreFacade(){
		
	}
	
	public Amministratore createAmministratore(String nome, String password){
		Amministratore a= new Amministratore();
		a.setNome(nome);
		a.setPassword(password);
		this.em.persist(a);
		return a;
	}
	
	public List<Amministratore> getAllAmministratore(){
		return this.em.createNamedQuery("Amministratore.findByNome", Amministratore.class).getResultList();
	}
	
	public Amministratore getAmministratore(Long id) {
		try {
			return this.em.createNamedQuery("Amministratore.findById", Amministratore.class).setParameter("id", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Amministratore getAmministratore(String nome){
		try {
			return this.em.createNamedQuery("Cameriere.findByNome", Amministratore.class).setParameter("nome", nome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}