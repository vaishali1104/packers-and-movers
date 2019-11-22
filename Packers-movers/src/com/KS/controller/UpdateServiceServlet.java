package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.ServiceBean;
import com.KS.bean.UserTypeBean;
import com.KS.dao.ServiceDao;
import com.KS.dao.UserTypeDao;

public class UpdateServiceServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String serviceId=request.getParameter("serviceId");
		String serviceType = request.getParameter("serviceType");
		
		ServiceBean bean = new ServiceBean();

		boolean isError = false;

		bean.setServiceId(serviceId);
		
		if (serviceType.trim().length() == 0) {
			isError = true;
			request.setAttribute("ServiceTypeError", "<font color='red'>Please Enter Service type</font>");
		}
		else 
		{ 
			int flag=0;
			for(int i=0;i<serviceType.trim().length();i++)
			{    
				if( (serviceType.charAt(i)>=33 && serviceType.charAt(i)<=64) || (serviceType.charAt(i)>=91 && serviceType.charAt(i)<=96) || (serviceType.charAt(i)>=123 && serviceType.charAt(i)<=126 ))
				{	
					isError = true;
					request.setAttribute("ServiceTypeError", "<font color='red'>Please Enter valid Service type</font>");
					flag=1;
					break;
				}
			}
				
			if(flag==0)
			{
				bean.setServiceType(serviceType);
				request.setAttribute("ServiceTypeValue", serviceType);
			}
		}
		
		RequestDispatcher rd = null;
		if (isError == true) 
		{
			request.setAttribute("ServiceBean", bean);
			rd = request.getRequestDispatcher("EditService.jsp");
		} 
		else
		{
			ServiceDao dao = new ServiceDao();
			if (dao.updateService(bean)) {
				rd = request.getRequestDispatcher("ListServiceServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}
