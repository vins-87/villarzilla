package it.villarzilla.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.villarzilla.facade.IndicatoreFacade;
import it.villarzilla.model.Indicatore;

@FacesConverter(forClass=Indicatore.class)
public class IndicatoreConverter implements Converter{
	
	private IndicatoreFacade indicatoreFacade;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		if(arg2==null || arg2.isEmpty()){
			return null;
		}
		Long id;
		try{
			id = Long.valueOf(arg2);
		}catch(NumberFormatException e){
			throw new ConverterException();
		}
		try {
			this.indicatoreFacade = (IndicatoreFacade) new InitialContext().lookup("java:comp/env/ejb/IndicatoreFacade");
		} catch (NamingException e) {
			throw new ConverterException();
		}
		return indicatoreFacade.getIndicatore(id);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		if(arg2==null){
			return null;
		}
		return arg2.toString();
	}

}