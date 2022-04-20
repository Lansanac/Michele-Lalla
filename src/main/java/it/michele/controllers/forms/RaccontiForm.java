package it.michele.controllers.forms;

import it.michele.beans.Esito;
import it.michele.beans.Poesie;
import it.michele.beans.Racconto;


public class RaccontiForm {

	private Racconto racconti;
	private Esito esito;
	public Racconto getRacconti() {
		return racconti;
	}
	public void setRacconti(Racconto racconti) {
		this.racconti = racconti;
	}
	public Esito getEsito() {
		return esito;
	}
	public void setEsito(Esito esito) {
		this.esito = esito;
	}
	@Override
	public String toString() {
		return "RaccontiForm [racconti=" + racconti + ", esito=" + esito + "]";
	}

}