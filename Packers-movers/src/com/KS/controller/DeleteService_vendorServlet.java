package com.KS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KS.dao.Service_vendorDao;

public class DeleteService_vendorServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ser_venId = request.getParameter("ser_venId");

		Service_vendorDao dao = new Service_vendorDao();
		if (dao.deleteService_vendor(ser_venId)) {
			response.sendRedirect("ListService_vendorServlet");
		} else {
			response.sendRedirect("Error.jsp");
		}
	}
}