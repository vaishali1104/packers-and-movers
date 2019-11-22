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

public class SignupServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String name=firstName+" "+lastName;
		String phoneNo=request.getParameter("phoneNo");
		String emailId = request.getParameter("emailId").trim();
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		String security_questionId=request.getParameter("security_questionId");
		String answer = request.getParameter("answer");
		
		UserBean userBean = new UserBean();

		boolean isError = false;

		if (name.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("NameError", "<font color='red'>Please Enter name</font>");
		}
		else
		{
            int flag=0;
			for(int i=0;i<name.trim().length();i++)
			{    
				
				if( (name.charAt(i)>=33 && name.charAt(i)<=64) || (name.charAt(i)>=91 && name.charAt(i)<=96) || (name.charAt(i)>=123 && name.charAt(i)<=126 ))
				{	
					isError = true;
					request.setAttribute("NameError", "<font color='red'>Please Enter valid name</font>");
					flag=1;
					break;
				}
			}
			
			if(flag==0)
			{
				userBean.setUserName(name);
				request.setAttribute("NameValue", name);
			}
		}
		
		
		if (phoneNo.trim().length() == 0 || phoneNo.trim().length()!=10) {
			isError = true;
			request.setAttribute("PhoneNoError", "<font color='red'>Please Enter valid Phone No</font>");
		} 
		else 
		{
			int flag=0;
			for(int i=0;i<phoneNo.trim().length();i++)
			{
				if( !(phoneNo.charAt(i)>=48 && phoneNo.charAt(i)<=57) )
				{
					isError = true;
					flag=1;
					request.setAttribute("PhoneNoError", "<font color='red'>Please Enter valid Phone No</font>");
				}
			}
			
			if(flag==0)
			{
				userBean.setPhoneNo(phoneNo);;
				request.setAttribute("PhoneNoValue", phoneNo);
			}
		}

		if (password.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("PasswordError", "<font color='red'>Please Enter Password</font>");
		} 
		else if( password.trim().length()<8)
		{
			isError = true;
			request.setAttribute("PasswordError", "<font color='red'>Please Enter minimum 8 characters</font>");
		}
		else
		{
			userBean.setUserPassword(password);
		}

		if (emailId.trim().length() == 0) {
			isError = true;
			request.setAttribute("EmailError", "<font color='red'>Please Enter Email</font>");
		} 
		else
		{
			userBean.setUserEmail(emailId);
			request.setAttribute("EmailValue", emailId);
		}
		
		
		if (answer.trim().length() == 0) {
			isError = true;
			request.setAttribute("AnswerError", "<font color='red'>Please Enter your answer</font>");
		} 
		else
		{
			userBean.setAnswer(answer);
			request.setAttribute("AnswerValue", answer);
		}
	
		if(userType == null || userType.equals("-1") ){
			isError = true;
			request.setAttribute("UserTypeError", "<font color='red'>Please select user type</font>");
		}else{
			userBean.setUserTypeId(userType);
		}
		
		
		if(security_questionId == null || security_questionId.equals("-1") ){
			isError = true;
			request.setAttribute("Security_questionIdError", "<font color='red'>Please select security question</font>");
		}else{
			userBean.setSecurity_questionId(security_questionId);
		}
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("Signup.jsp");
		}
		else 
		{
			UserDao dao = new UserDao();
			userBean  = dao.insertUser(userBean);
			if (userBean.getUserId()!= null)
			{
			HttpSession session = request.getSession();
				session.setAttribute("UserBean", userBean);
			
				
				// mail functionality
				//======================================================================
				
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
//				String emailId = (String)session.getAttribute("userEmailId");
				
				String to = userBean.getUserEmail().trim();// change accordingly

				System.out.println("from : " + user);
				System.out.println("emailId : " + emailId);				
				System.out.println("userPassword : " + userPassword);					
				
				// Get the session object
				Properties props = new Properties();
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.auth", mail_smtp_auth);
				props.put("mail.smtp.starttls.enable", mail_smtp_starttls_enable);
				props.put("mail.smtp.port", mail_smtp_port);

				
				Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() 
					{
						return new PasswordAuthentication(user, userPassword);
					}
				});

				// Compose the message
				try {
					MimeMessage message = new MimeMessage(mailSession);
					message.setFrom(new InternetAddress(user));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					message.setSubject("Account has been successfully registered at Heraferi!");
//					message.setText("Your Account has been successfully registered at Herapheri! Dear \"+ userBean.getUserName()+\"  \\\",\\\\r\\\\n\\\" + \\r\\n\" + \r\n" + 
//							"				    		\"							\\\"To help protect your account from unauthorized use, Please don not share your password of Herapheri and secret questions. ");

					
					response.setContentType("text/html");
					//3) create MimeBodyPart object and set your message text     
				    BodyPart messageBodyPart1 = new MimeBodyPart();  
				    messageBodyPart1.setText("Your Account has been successfully registered at Herapheri! \n \nDear "+ userBean.getUserName()+", \n \n      \t        To help protect your account from unauthorized use, Please don not share your password of Herapheri and secret questions. ");  
				      
				    //4) create new MimeBodyPart object and set DataHandler object to this object      
				    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
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
				
						
				
				//======================================================================
				//System.out.println("userId=="+userBean.getUserId());
				if(userBean.getUserTypeId().equals("2"))
					rd = request.getRequestDispatcher("Vendor_detailForm.jsp");
				else
				{
				//request.setAttribute("UserBean", bean);
				rd = request.getRequestDispatcher("login.jsp");
				//rd = request.getRequestDispatcher("ListUserServlet");
				}
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}
