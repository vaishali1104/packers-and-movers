package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.Service_vendorBean;
import com.KS.dao.Service_vendorDao;

public class Service_vendorFormServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String serviceId = request.getParameter("serviceId");
		Service_vendorBean bean = new Service_vendorBean();

		boolean isError = false;

		if (serviceId.trim().length() == 0 || serviceId.equals("-1")) {
			isError = true;
			request.setAttribute("ServiceIdError", "<font color='red'>Please Enter choose service</font>");
		}
		/*else 
		{
			for(int i=0;i<name.trim().length();i++)
			{
				if(name.charAt(i)>0 && name.charAt(i)<9)
				{	
					isError = true;
					request.setAttribute("nameError", "<font color='red'>Please Enter valid name</font>");
				}
			}
		}*/
		else
		{
			bean.setServiceId(serviceId);
			request.setAttribute("ServiceIdValue", serviceId);
		}
		
		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("Service_vendorForm.jsp");
		}
		else 
		{
			Service_vendorDao dao = new Service_vendorDao();
			if (dao.insertService_vendor(bean)) {
				rd = request.getRequestDispatcher("ListService_vendorServlet");
			} 
			else
			{
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}