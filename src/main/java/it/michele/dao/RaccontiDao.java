package it.michele.dao;

import java.util.List;

import it.michele.beans.Contatto;
import it.michele.beans.Racconto;


public interface RaccontiDao {
    public List<Racconto> getListaRacconti() throws Exception;
    public Racconto getRacconto(Integer id) throws Exception;
    public Boolean insert(String titolo, String descrizione, int anno) throws Exception;
    public boolean update(Integer id, String titolo, String descrizione, Integer anno) throws Exception;
    public boolean delete(Integer id) throws Exception;
}