package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.ServiceDao;
import com.KS.dao.UserDao;
import com.KS.dao.UserTypeDao;

public class DeleteServiceServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String serviceId = request.getParameter("serviceId");

		ServiceDao dao = new ServiceDao();
		if (dao.deleteService(serviceId)) {
			response.sendRedirect("ListServiceServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}