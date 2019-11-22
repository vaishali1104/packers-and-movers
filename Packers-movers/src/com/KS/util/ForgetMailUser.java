package com.KS.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class ForgetMailUser 
{
	public static void main(String[] args) 
	{
		FileInputStream fin = null;
	
		Properties prop = new Properties();
		
		try 
		{
			fin = new FileInputStream("C:\\Users\\PALAL\\eclipse-workspace\\Project_final\\WebContent\\mailconfig.properties");
			prop.load(fin);
		} catch (FileNotFoundException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final String host = prop.getProperty("host").trim();
		final String user = prop.getProperty("user").trim();
		final String password = prop.getProperty("password").trim();
		final String mail_smtp_auth = prop.getProperty("mail.smtp.auth").trim();
		final String mail_smtp_starttls_enable = prop.getProperty("mail.smtp.starttls.enable").trim();
		final String mail_smtp_port = prop.getProperty("mail.smtp.port").trim();
		
		
//		String host = "smtp.gmail.com";
//		final String user = "rahul.kirpekar@gmail.com";// change accordingly
//		final String password = "alpha*!#123*";// change accordingly

			
		
		String to ="" ;// change accordingly

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.port", "587");

		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Forgot mail");
			message.setText("This is simple program of sending email using JavaMail API");

			
			
			//3) create MimeBodyPart object and set your message text     
		    BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText("This is message body");  
		      
		    //4) create new MimeBodyPart object and set DataHandler object to this object      
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		  
		    
		    
		    
		    
		    
		    String filename = "C:\\Users\\Rahul Kirpekar\\Desktop\\config.properties";//change accordingly  
		    DataSource source = new FileDataSource(filename);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  
		    //5) create Multipart object and add MimeBodyPart objects to this object      
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		  
		    //6) set the multiplart object to the message object  
		    message.setContent(multipart );  
		     
			
			
			
			
			
			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}