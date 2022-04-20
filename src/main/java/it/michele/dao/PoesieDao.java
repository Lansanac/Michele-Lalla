package it.michele.dao;

import java.util.List;

import it.michele.beans.Poesie;


public interface PoesieDao {
    public List<Poesie> getListaPoesie() throws Exception;
    public Poesie getPoesie(Integer id) throws Exception;
    public boolean insert(String titolo, String descrizione, int anno) throws Exception;
    public boolean update(Integer id, String titolo, String descrizione, Integer anno) throws Exception;
    public boolean delete(Integer id) throws Exception;
}