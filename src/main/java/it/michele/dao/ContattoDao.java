package it.michele.dao;

import java.util.List;

import it.michele.beans.Contatto;

public interface ContattoDao {
    public List<Contatto> getListaContatto() throws Exception;
//    public Racconto getContatto(Integer id) throws Exception;
    public void insert(Contatto contatto) throws Exception;
//    public void update(Contatto contatto) throws Exception;
//    public void delete(Integer id) throws Exception;
}