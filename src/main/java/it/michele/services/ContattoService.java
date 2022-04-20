package it.michele.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.michele.beans.Contatto;
import it.michele.services.exceptions.ServiceException;

public interface ContattoService {
    public List<Contatto> getListContatto() throws ServiceException;
//    public Poesie getListContatto(Integer id) throws ServiceException;
    public void insert(Contatto contatto) throws ServiceException;
//    public void update(Racconto racconti) throws ServiceException;
//    public void delete(Integer id) throws ServiceException;
    public void sendSimpleMessage(Contatto contatto, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}