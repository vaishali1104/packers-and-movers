package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.FeedbackBean;
import com.KS.dao.FeedbackDao;

public class ContactFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String description = request.getParameter("description");

		FeedbackBean bean = new FeedbackBean();

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
				bean.setName(name);
				request.setAttribute("NameValue", name);
			}
		}
		
		
		
		
		
		if (description.trim().length() == 0 || description.trim().length()>50) {
			isError = true;
			request.setAttribute("DescriptionError", "<font color='red'>Please Enter proper Description</font>");
		}
		else
		{
			bean.setDescription(description);
			request.setAttribute("DescriptionValue", description);
		}
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("contact.jsp");
		}
		else 
		{
			FeedbackDao dao = new FeedbackDao();
			if (dao.insertFeedback(bean)) {
				request.setAttribute("SuccessMessage","<font color='white'>Thank you for your feedback</font>");
				rd = request.getRequestDispatcher("contact.jsp");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}