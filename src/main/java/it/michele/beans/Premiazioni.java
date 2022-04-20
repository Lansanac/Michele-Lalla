package it.michele.beans;


public class Premiazioni {
	
	private int id;
	private String titolo;
	private String data;
	private String citta;
	private String descrizione;
	
	public Premiazioni() {
		// TODO Auto-generated constructor stub
	}

	public Premiazioni(String titolo, String data, String citta, String descrizione) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.citta = citta;
		this.descrizione = descrizione;
	}

	public Premiazioni(int id, String titolo, String data, String citta, String descrizione) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.data = data;
		this.citta = citta;
		this.descrizione = descrizione;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String dataPubblicazione) {
		this.data = dataPubblicazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Premiazioni [id=" + id + ", titolo=" + titolo + ", data=" + data + ", citta=" + citta + ", descrizione="
				+ descrizione + "]";
	}


}
