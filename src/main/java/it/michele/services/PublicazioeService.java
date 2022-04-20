package it.michele.services;

import java.util.List;

import it.michele.beans.Pubblicazione;
import it.michele.services.exceptions.ServiceException;

public interface PublicazioeService {
    public List<Pubblicazione> getListPubblicazione() throws ServiceException;
    public Pubblicazione getPublicazione(int id) throws ServiceException;
    public boolean insert(Pubblicazione publicazione) throws ServiceException;
    public boolean update(Pubblicazione pubblicazione) throws ServiceException;
    public boolean delete(int id) throws ServiceException;
}