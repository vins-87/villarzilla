package it.villarzilla.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import it.villarzilla.facade.IndicatoreFacade;
import it.villarzilla.model.Indicatore;
import it.villarzilla.model.TipologiaEsame;

@ManagedBean(name="indicatoreController")
public class IndicatoreController {

	private String nome;
	private TipologiaEsame tipologiaEsame;
	
	private Indicatore indicatore;
	
	@EJB
	private IndicatoreFacade indicatoreFacade;
	
	public IndicatoreController(){
		
	}
	
	public String createIndicatore(){
		this.indicatore = indicatoreFacade.createIndicatore(nome, tipologiaEsame);
		return "/indicatore.xhtml";
	}
	
	public List<Indicatore> getList(){
		return indicatoreFacade.getAllIndicatore();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}

	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}

	public Indicatore getIndicatore() {
		return indicatore;
	}

	public void setIndicatore(Indicatore indicatore) {
		this.indicatore = indicatore;
	}

	public IndicatoreFacade getIndicatoreFacade() {
		return indicatoreFacade;
	}

	public void setIndicatoreFacade(IndicatoreFacade indicatoreFacade) {
		this.indicatoreFacade = indicatoreFacade;
	}
	
	
}
