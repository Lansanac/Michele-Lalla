package it.michele.beans;

public class Pubblicazione {

	private Integer id;
	private String titolo;
	private String description;
	private int dataPubblicazioneM;
	private String image;

	public Pubblicazione() {
		// TODO Auto-generated constructor stub
	}

	public Pubblicazione(Integer id, String titolo, String description, int dataPubblicazioneM, String image) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.description = description;
		this.dataPubblicazioneM = dataPubblicazioneM;
		this.image = image;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDataPubblicazioneM() {
		return dataPubblicazioneM;
	}

	public void setDataPubblicazioneM(int dataPubblicazioneM) {
		this.dataPubblicazioneM = dataPubblicazioneM;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Pubblicazione [id=" + id + ", titolo=" + titolo + ", description=" + description
				+ ", dataPubblicazioneM=" + dataPubblicazioneM + ", image=" + image + "]";
	}

}
