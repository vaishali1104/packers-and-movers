package com.KS.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.bean.CityBean;
import com.KS.bean.Service_vendorBean;
import com.KS.bean.UserBean;
import com.KS.dao.CityDao;
import com.KS.dao.Service_vendorDao;
import com.KS.dao.UserDao;

public class UpdateService_vendorServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ser_venId = request.getParameter("ser_venId");
		String serviceId = request.getParameter("serviceId");
		String userId = request.getParameter("userId");
		Service_vendorBean bean = new Service_vendorBean();

		boolean isError = false;
		Service_vendorDao daoC = new Service_vendorDao();
		bean = daoC.getDataByPk(ser_venId);
		
		if (serviceId==null || serviceId.equals("-1")) {
			isError = true;
			request.setAttribute("ServiceIdError", "<font color='red'>Please choose service</font>");
		}
		/*
		  else { for(int i=0;i<name.trim().length();i++) { if(name.charAt(i)>0 &&
		  name.charAt(i)<9) { isError = true; request.setAttribute("nameError",
		  "<font color='red'>Please Enter valid name</font>"); } } }
		 */
		else {
			bean.setServiceId(serviceId);
			request.setAttribute("ServiceIdValue", serviceId);
		}

		RequestDispatcher rd = null;
		if (isError == true) {
			request.setAttribute("Service_vendorBean", bean);
			rd = request.getRequestDispatcher("EditService_vendor.jsp");
		} 
		else
		{
			Service_vendorDao dao = new Service_vendorDao();
			if (dao.updateService_vendor(bean)) {
				System.out.println("done...");
				rd = request.getRequestDispatcher("ListService_vendorServlet");
			} else {
				request.setAttribute("Service_vendorBean", bean);
				rd = request.getRequestDispatcher("Error.jsp");
			}
		}
		rd.forward(request, response);
	}
}