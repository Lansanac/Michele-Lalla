package it.michele.services;

import java.util.List;

import org.springframework.stereotype.Service;

import it.michele.beans.Opere;
import it.michele.services.exceptions.ServiceException;

@Service	
public interface OpereService {
    public List<Opere> getListaOpere() throws ServiceException;
    /*public Premiazioni getPremiazioni(Integer id) throws ServiceException;
    public void insert(Premiazioni racconti) throws ServiceException;
    public void update(Premiazioni racconti) throws ServiceException;
    public void delete(Integer id) throws ServiceException;*/
}