package it.villarzilla.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import it.villarzilla.facade.PazienteFacade;
import it.villarzilla.model.Paziente;

@FacesConverter(forClass=Paziente.class)
public class PazienteConverter implements Converter{
	
	private PazienteFacade pazienteFacade;

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
			this.pazienteFacade = (PazienteFacade) new InitialContext().lookup("java:comp/env/ejb/PazienteFacade");
		} catch (NamingException e) {
			throw new ConverterException();
		}
		return pazienteFacade.getPaziente(id);
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