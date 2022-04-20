package it.michele.dao;

import java.util.List;

import it.michele.beans.Pubblicazione;

public interface PublicazioeDao {
	public List<Pubblicazione> getListaPubblicazione() throws Exception;

	public Pubblicazione getPubblicazione(int id) throws Exception;

	public boolean insert(String titolo, String escription, int ataPubblicazione, String image) throws Exception;

	public boolean update(int id, String titolo, String descrizione, int anno, String image) throws Exception;

	public boolean delete(int id) throws Exception;
}