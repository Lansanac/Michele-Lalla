package it.michele.services;

import java.util.List;

import it.michele.beans.Poesie;
import it.michele.services.exceptions.ServiceException;


public interface PoesieService {
    public List<Poesie> getListaPoesie() throws ServiceException;
    public Poesie getPoesie(Integer id) throws ServiceException;
    public Boolean insert(Poesie poesie) throws ServiceException;
    public boolean update(Poesie anagrafica) throws ServiceException;
    public boolean delete(Integer id) throws ServiceException;
}