package it.michele.services;

import java.util.List;

import it.michele.beans.Opere;
import it.michele.beans.Premiazioni;
import it.michele.services.exceptions.ServiceException;


public interface BiografiaService {
    public List<Premiazioni> getListaPremiazioni() throws ServiceException;
    public Premiazioni getPremiazioni(Integer id) throws ServiceException;
    public Opere getOpere(Integer id) throws ServiceException;
    public boolean insert(Premiazioni premiazioni) throws ServiceException;
    public boolean insertOpere(Opere opere) throws ServiceException;
    public boolean update(Premiazioni premiazioni) throws ServiceException;
    public boolean updateOpere(Opere opere) throws ServiceException;
    public boolean delete(Integer id) throws ServiceException;
    public boolean deleteOpere(Integer id) throws ServiceException;
}