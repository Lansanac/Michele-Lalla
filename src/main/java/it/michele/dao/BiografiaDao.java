package it.michele.dao;

import java.util.List;

import it.michele.beans.Contatto;
import it.michele.beans.Opere;
import it.michele.beans.Poesie;
import it.michele.beans.Premiazioni;
import it.michele.beans.Racconto;


public interface BiografiaDao {
    public List<Premiazioni> getListaPremiazioni() throws Exception;
    public Premiazioni getPremiazioni(Integer id) throws Exception;
    public Opere getOpere(Integer id) throws Exception;
    public boolean insert(String titolo, String descrizione, String citta, int anno) throws Exception;
    public boolean insert(int anno, String descrizione) throws Exception;
    public boolean update(Integer id, String titolo, String descrizione, String citta, Integer anno) throws Exception;
    public boolean update(Integer id, Integer data, String descrizione) throws Exception;
    public boolean delete(Integer id) throws Exception;
    public boolean deleteOpere(Integer id) throws Exception;
}