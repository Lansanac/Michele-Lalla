package it.michele.beans;


@Entity
public class Racconto {
	
	private Integer id;
	private String titolo;
	private String descrizione;
	private String annoPubblicazione;

	public Racconto() {
		// TODO Auto-generated constructor stub
	}

	public Racconto(Integer id, String titolo, String descrizione, String annoPubblicazione) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.annoPubblicazione = annoPubblicazione;
	}
	public Racconto(String titolo, String descrizione, String annoPubblicazione) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.annoPubblicazione = annoPubblicazione;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	@Override
	public String toString() {
		return "Racconti [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", dataPubblicazione="
				+ annoPubblicazione + "]";
	}


}
