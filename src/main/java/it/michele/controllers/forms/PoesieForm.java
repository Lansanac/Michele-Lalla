package it.michele.controllers.forms;

import it.michele.beans.Esito;
import it.michele.beans.Poesie;


public class PoesieForm {

	private Poesie poesie;
	private Esito esito;

	public PoesieForm() {
		super();
	}

	public PoesieForm(Poesie poesie) {
		super();
		this.poesie = poesie;
	}

	public Poesie getAnagrafica() {
		return poesie;
	}

	public void setAnagrafica(Poesie poesie) {
		this.poesie = poesie;
	}

	public Esito getEsito() {
		return esito;
	}

	public void setEsito(Esito esito) {
		this.esito = esito;
	}
}