package com.KS.controller;

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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.KS.bean.UserBean;
import com.KS.dao.UserDao;

public class UpdatePasswordServlet extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		// validation
		boolean isError=false;
		
		if(password.trim().length()==0)
		{
			isError=true;
			request.setAttribute("PasswordError","<font color='red'>Please enter password</font>");
		}
		else if(password.trim().length()<8)
		{
			isError=true;
			request.setAttribute("PasswordError","<font color='red'>Please enter minimum 8 digit password</font>");
		}
		
		if(confirmPassword.trim().length()==0)
		{
			isError=true;
			request.setAttribute("ConfirmPasswordError","<font color='red'>Please Re-enter your password</font>");
		}
		else if(confirmPassword.trim().length()<8)
		{
			isError=true;
			request.setAttribute("ConfirmPasswordError","<font color='red'>Please enter minimum 8 digit password</font>");
		}
		
		if(isError==false)
		{
			if(!password.equals(confirmPassword))
			{
				isError=true;
				request.setAttribute("CheckError","<font color='red'>Both the passwords does not match</font>");
			}
		}
		
		
		RequestDispatcher rd=null;
		if(isError==true)
		{
			rd=request.getRequestDispatcher("UpdatePassword.jsp");
		}
		else if(password.equals(confirmPassword))
		{
			HttpSession session =request.getSession();
			UserBean userBean = (UserBean) session.getAttribute("UserBean");
			String userId = userBean.getUserId();
			UserDao userDao = new UserDao();
			if (userDao.updatePassword(userId, password))
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
				final String userPassword = prop.getProperty("password").trim();
				final String mail_smtp_auth = prop.getProperty("mail.smtp.auth").trim();
				final String mail_smtp_starttls_enable = prop.getProperty("mail.smtp.starttls.enable").trim();
				final String mail_smtp_port = prop.getProperty("mail.smtp.port").trim();
				
//				session  = request.getSession();
				String emailId = (String)session.getAttribute("UserEmailId");
				
				String to = emailId.trim();// change accordingly

				System.out.println("from : " + user);
				System.out.println("emailId : " + emailId);				
				
				
				// Get the session object
				Properties props = new Properties();
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.auth", mail_smtp_auth);
				props.put("mail.smtp.starttls.enable", mail_smtp_starttls_enable);
				props.put("mail.smtp.port", mail_smtp_port);

				
				Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, userPassword);
					}
				});

				// Compose the message
				try {
					MimeMessage message = new MimeMessage(mailSession);
					message.setFrom(new InternetAddress(user));	
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			//subject
					message.setSubject("Password Changed!");
				
					message.setText("Your password has been reset successfully at Her@feri!");
				
					
					//3) create MimeBodyPart object and set your message text     
				    BodyPart messageBodyPart1 = new MimeBodyPart();  
				//msg
				    messageBodyPart1.setText("Your password has been reset successfully at Her@feri!");  
				      
				    //4) create new MimeBodyPart object and set DataHandler object to this object      
				    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
				  
				    
				    
				    
				    
				    //images
				    String filename = "C:\\Users\\PALAL\\eclipse-workspace\\Project_final\\WebContent\\images\\mailsuccess.jpg";//change accordingly  
				    DataSource source = new FileDataSource(filename);  
				    messageBodyPart2.setDataHandler(new DataHandler(source));  
				    messageBodyPart2.setFileName(filename);  
				    //5) create Multipart object and add MimeBodyPart objects to this object      
				    Multipart multipart = new MimeMultipart();  
				    multipart.addBodyPart(messageBodyPart1);  
				    multipart.addBodyPart(messageBodyPart2);  
				  
				    //6) set the multiplart object to the message object  
				    message.setContent(multipart);  
				     
					// send the message
					Transport.send(message);

					System.out.println("message sent successfully...");


				} catch (MessagingException e) {
					e.printStackTrace();
				}
			
				response.sendRedirect("login.jsp");
			}
			else
			{
				rd=request.getRequestDispatcher("Error.jsp");
			}
		}
		//rd.forward(request, response);
	}
}