package it.michele.controllers.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.michele.beans.Poesie;

@Component
public class AnagraficaValidator implements Validator
{
	@Override
	public boolean supports(Class<?> clazz)
	{
		return Poesie.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		Poesie anagrafica = (Poesie)target;

//		if(anagrafica.getNome() == null || anagrafica.getNome().equals(""))
//		{
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anagrafica.nome", "errors.required", new Object[]{"Nome"});
//		}
//		
//		if(anagrafica.getCognome() == null || anagrafica.getCognome().equals(""))
//		{
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anagrafica.cognome", "errors.required", new Object[]{"Cognome"});
//		}
//		
//		if(anagrafica.getCodiceFiscale() == null || anagrafica.getCodiceFiscale().equals(""))
//		{
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anagrafica.codiceFiscale", "errors.required", new Object[]{"Codice Fiscale"});
//		}
//
//		if(anagrafica.getEta() == null)
//		{
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anagrafica.eta", "errors.required", new Object[]{"Et?"});
//		}
//		
//		if(anagrafica.getSesso() == null || anagrafica.getSesso().equals(""))
//		{
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anagrafica.sesso", "errors.required", new Object[]{"Sesso"});
//		}
//		if(anagrafica.getCurriculum() == null || anagrafica.getCurriculum().equals(""))
//		{
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anagrafica.curriculum", "errors.required", new Object[]{"Curriculum"});
//		}
	}
}