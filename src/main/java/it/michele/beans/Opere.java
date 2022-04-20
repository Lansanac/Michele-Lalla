package it.michele.beans;

import java.util.Date;

public class Opere {
	
	private int id;
	private int data;
	private String descrizione;
	
	public Opere() {
		// TODO Auto-generated constructor stub
	}

	public Opere(int id, int data, String descrizione) {
		super();
		this.id = id;
		this.data = data;
		this.descrizione = descrizione;
	}

	public Opere(int data, String descrizione) {
		super();
		this.data = data;
		this.descrizione = descrizione;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Opere [id=" + id + ", data=" + data + ", descrizione=" + descrizione + "]";
	}

}
