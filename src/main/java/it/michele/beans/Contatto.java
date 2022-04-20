package it.michele.beans;

public class Contatto {
	
	private int id;
	private String nome;
	private String email;
	private String soggetto;
	private String messaggio;

	public Contatto() {
		super();
	}

	public Contatto(String nome, String email, String soggetto, String messaggio) {
		super();
		this.nome = nome;
		this.email = email;
		this.soggetto = soggetto;
		this.messaggio = messaggio;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoggetto() {
		return soggetto;
	}

	public void setSoggetto(String soggetto) {
		this.soggetto = soggetto;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	@Override
	public String toString() {
		return "Contatto [nome=" + this.nome + ", email=" + email + ", soggetto=" + soggetto
				+ ", messaggio=" + messaggio + "]";
	}


}
