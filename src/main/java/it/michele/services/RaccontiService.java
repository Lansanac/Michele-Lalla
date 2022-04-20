package it.michele.services;

import java.util.List;

import it.michele.beans.Poesie;
import it.michele.beans.Racconto;
import it.michele.services.exceptions.ServiceException;


public interface RaccontiService {
    public List<Racconto> getListaRacconto() throws ServiceException;
    public Racconto getRacconto(Integer id) throws ServiceException;
    public Boolean insert(Racconto racconti) throws ServiceException, Exception;
    public boolean update(Racconto racconti) throws ServiceException;
    public boolean delete(Integer id) throws ServiceException;
}