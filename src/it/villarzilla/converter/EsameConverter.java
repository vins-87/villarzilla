package it.villarzilla.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.villarzilla.facade.EsameFacade;
import it.villarzilla.model.Esame;

@FacesConverter(forClass=Esame.class)
public class EsameConverter implements Converter{
	
	private EsameFacade esameFacade;

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
			this.esameFacade = (EsameFacade) new InitialContext().lookup("java:comp/env/ejb/EsameFacade");
		} catch (NamingException e) {
			throw new ConverterException();
		}
		return esameFacade.getEsame(id);
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