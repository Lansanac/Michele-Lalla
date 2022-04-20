package it.michele.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.michele.beans.Opere;

public interface OpereDao {
    public List<Opere> getListaOpere() throws Exception;
    /*public Racconto getRacconti(Integer id) throws Exception;
    public void insert(Racconto racconti) throws Exception;
    public void update(Racconto racconti) throws Exception;
    public void delete(Integer id) throws Exception;
    public List<Racconto> getListaContrattiAnagrafica(Integer id) throws Exception;*/
}