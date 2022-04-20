package it.michele.beans;


public class Poesie {
	
	private int id;
	private String titolo;
	private String descrizione;
	private String dataPubblicazione;

	public Poesie() {
		// TODO Auto-generated constructor stub
	}

	public Poesie(int id, String titolo, String descrizione, int dataPubblicazioneM, String dettaglio) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.dataPubblicazione = dataPubblicazione;
	}
	public Poesie(String titolo, String descrizione, int dataPubblicazioneM, String dettaglio) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.dataPubblicazione = dataPubblicazione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(String dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}


	@Override
	public String toString() {
		return "Poesie [id=" + id + ", titolo=" + titolo + ", description=" + descrizione + ", dataPubblicazione="
				+ dataPubblicazione + "]";
	}

}
