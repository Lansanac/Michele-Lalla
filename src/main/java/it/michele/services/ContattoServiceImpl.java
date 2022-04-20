package it.michele.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.bouncycastle.openpgp.PGPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.michele.beans.Contatto;
import it.michele.dao.ContattoDao;
import it.michele.dao.RaccontiDao;
import it.michele.services.exceptions.ServiceException;

//import com.didisoft.pgp.mail.PGPMailUtils;
@Service
public class ContattoServiceImpl implements ContattoService {

	@Autowired
	private ContattoDao contattoiDao = null;
	
	private static Logger logger = Logger.getLogger(ContattoServiceImpl.class);

	@Override
	public void sendSimpleMessage(Contatto contact, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("ContattoServiceImpl.sendSimpleMessage ");
		logger.info("Contatto	--->>	" + contact);
		System.out.println("ContattoServiceImpl.sendSimpleMessage");
		System.out.println("Contatto	--->>	" + contact);
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		String contatto = "Nome: " + contact.getNome() + "\n";
		contatto += "Email: " + contact.getEmail() + "\n";
		contatto += "Messaggio: " + contact.getMessaggio() + "\n";

		// Recipient's email ID needs to be mentioned.
		String to = "lansanaweb0@gmail.com";
//		String to = "lansanac124@gmail.com";
//	    String to = "tirondenisia@gmail.com";
//	    String to = "lansana.camara@outlook.it";

		// Sender's email ID needs to be mentioned
		String from = "web@gmail.com";
		//String from = "lansanaweb0@gmail.com";

		// Assuming you are sending email from localhost String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.store.protocol", "pop3");
		properties.put("mail.transport.protocol", "smtp");
		final String username = "lansanaweb0@gmail.com";//
		final String password = "MicheleLalla";

		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		response.setContentType("text/jsp");
		PrintWriter out = response.getWriter();

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject(contact.getSoggetto());

			// Now set the actual message
			message.setText(contatto);

			message.setSentDate(new Date());

			// Send message
			Transport.send(message);
            System.out.println("message sent");
    		logger.info("ContattoServiceImpl.sendSimpleMessage -->> message sent");

            //JOptionPane.showMessageDialog(null, "Message Sent!", "Sent", JOptionPane.INFORMATION_MESSAGE);
			
			String title = "Send Email";
			String res = "Il messaggio é sta inviato con successo...";
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

			out.println(docType + "<html>\n" + 
					"<head><title>" + title + "</title></head>\n" + 
						"<body bgcolor = \"#f0f0f0\">\n" + 
							"<h1 align = \"center\">" + title + "</h1>\n" + 
							"<p align = \"center\">" + res + "</p>\n" + 
						"</body>" + 
					" </html>");
		} catch (MessagingException mex) {
			
			logger.info("message sent Exception -->> ", mex);
			mex.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(Contatto contatto) throws ServiceException {
		logger.info("ContattoServiceImpl.insert ");

		try {
			contattoiDao.insert(contatto);
		} catch (Exception e) {
			logger.info("ContattoServiceImpl.insert Exception -->> ", e);
			e.printStackTrace();
		}
	}

	@Override
	public List<Contatto> getListContatto() throws ServiceException {
		logger.info("ContattoServiceImpl.getListContatto ");
		List<Contatto> contattos = new ArrayList<Contatto>();
		try {
			contattos = contattoiDao.getListaContatto();
		} catch (Exception e) {
			logger.info("ContattoServiceImpl.getListContatto Exception -->> ", e);
			e.printStackTrace();
		}
		return contattos;
	}

}