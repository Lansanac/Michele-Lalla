package it.michele.dao;

import java.sql.Blob;
import java.util.List;

import it.michele.beans.Pubblicazione;

public interface PublicazioeDao {
	public List<Pubblicazione> getTitolo() throws Exception;
	
	public List<Pubblicazione> getListaPubblicazione() throws Exception;

	public Pubblicazione getPubblicazione(int id) throws Exception;

	public boolean insert(String titolo, String escription, int ataPubblicazione, Blob image) throws Exception;

	public boolean update(int id, String titolo, String descrizione, int anno, Blob image) throws Exception;

	public boolean delete(int id) throws Exception;
}